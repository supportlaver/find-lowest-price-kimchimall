package com.supportkim.kimchimall.kimchi.service;

import com.supportkim.kimchimall.kimchi.controller.port.FindLowestPriceService;
import com.supportkim.kimchimall.kimchi.controller.port.KimchiService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.infrastructure.LowestPriceKimchiCacheRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto.*;
import static feign.FeignException.*;

@Service
@RequiredArgsConstructor
@Slf4j @Builder
public class KimchiServiceImpl implements KimchiService {

    private final FindLowestPriceService findLowestPriceService;
    private static final String NAVER_OPEN_API_CIRCUIT_BREAKER_CONFIG = "naverOpenApiCircuitBreakerConfig";
    private final LowestPriceKimchiCacheRepository lowestPriceKimchiCacheRepository;

    @Override
    @CircuitBreaker(name = NAVER_OPEN_API_CIRCUIT_BREAKER_CONFIG , fallbackMethod = "fallback")
    public FindLowestPriceResponseDto getFindLowestPrice(String type , String sort , int display , int start) {
        FindLowestPriceResponseDto findLowestPriceKimchis = findLowestPriceService.getFindLowestPriceKimchis(type, sort, display, start);
        // 캐시 저장
        lowestPriceKimchiCacheRepository.setLowestPriceKimchiCache(findLowestPriceKimchis.getItems(),type);
        return findLowestPriceKimchis;
    }

    /**
     * fallback Method 는 CircuitBreaker 에서 지정한 메서드의 시그니처가 동일해야한다.
     * 반환값 , 파라미터가 동일해야하며 추가로 Exception 인자까지 가지고 있어야한다.
     */
    public FindLowestPriceResponseDto fallback(String type , String sort , int display , int start,CallNotPermittedException ex) {
        log.info("현재 Naver API 에 문제가 있습니다. 잠시후에 다시 시도해주세요.");
        // 캐시된 상품을 노출
        List<ItemDto> cacheList = lowestPriceKimchiCacheRepository.getLowestPriceKimchiCache(type);

        // 로그는 DB 에 저장 예정
        log.info("fallback-> CallNotPermittedException : {}" , ex.getMessage());
        log.info("fallback-> CallNotPermittedException : {}" , ex.getStackTrace());

        return FindLowestPriceResponseDto.from(cacheList, display, start);
    }

    public FindLowestPriceResponseDto fallback(String type , String sort , int display , int start,TooManyRequests ex) {
        log.info("현재 사용자가 많아 요청 시간이 오래 걸리고 있습니다. 잠시후에 다시 시도해주세요");
        // 캐시한 상품을 노출
        List<ItemDto> cacheList = lowestPriceKimchiCacheRepository.getLowestPriceKimchiCache(type);

        // 로그는 DB 에 저장 예정
        log.info("fallback-> NaverApiException : {}" , ex.getMessage());
        log.info("fallback-> NaverAPiException : {}" , ex.getStackTrace());

        // Cache 된 상품을 반환한다.
        return FindLowestPriceResponseDto.from(cacheList, display, start);
    }

}
