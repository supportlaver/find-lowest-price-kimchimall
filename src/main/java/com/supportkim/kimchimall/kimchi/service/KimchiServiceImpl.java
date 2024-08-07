package com.supportkim.kimchimall.kimchi.service;

import com.supportkim.kimchimall.kimchi.controller.port.FindLowestPriceService;
import com.supportkim.kimchimall.kimchi.controller.port.KimchiService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static feign.FeignException.*;

@Service
@RequiredArgsConstructor
@Slf4j @Builder
public class KimchiServiceImpl implements KimchiService {

    private final FindLowestPriceService findLowestPriceService;
    private static final String NAVER_OPEN_API_CIRCUIT_BREAKER_CONFIG = "naverOpenApiCircuitBreakerConfig";

    @Override
    @CircuitBreaker(name = NAVER_OPEN_API_CIRCUIT_BREAKER_CONFIG , fallbackMethod = "fallback")
    public FindLowestPriceResponseDto getFindLowestPrice(String type , String sort , int display , int start) {
        return findLowestPriceService.getFindLowestPriceKimchis(type , sort, display, start);
    }

    /**
     * fallback Method 는 CircuitBreaker 에서 지정한 메서드의 시그니처가 동일해야한다.
     * 반환값 , 파라미터가 동일해야하며 추가로 Exception 인자까지 가지고 있어야한다.
     */
    private FindLowestPriceResponseDto fallback(String type , String sort , CallNotPermittedException ex) {
        log.error("현재 Naver API 에 문제가 있습니다. 잠시후에 다시 시도해주세요.");
        log.error("fallback-> CallNotPermittedException : {}" , ex.getMessage());
        log.error("fallback-> CallNotPermittedException : {}" , ex.getStackTrace());
        return new FindLowestPriceResponseDto();
    }

    private FindLowestPriceResponseDto fallback(String type , String sort , TooManyRequests ex) {
        // log 를 DB 저장
        log.info("현재 사용자가 많아 요청 시간이 오래 걸리고 있습니다. 잠시후에 다시 시도해주세요");
        log.error("fallback-> NaverApiException : {}" , ex.getMessage());
        log.error("fallback-> NaverAPiException : {}" , ex.getStackTrace());

        // Cache 된 상품을 반환한다.
        return new FindLowestPriceResponseDto();
    }

}
