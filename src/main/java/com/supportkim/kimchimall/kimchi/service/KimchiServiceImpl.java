package com.supportkim.kimchimall.kimchi.service;

import com.supportkim.kimchimall.kimchi.controller.port.FindLowestPriceService;
import com.supportkim.kimchimall.kimchi.controller.port.KimchiService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.domain.KimchiType;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KimchiServiceImpl implements KimchiService {

    private final FindLowestPriceService findLowestPriceService;

    @Override
    @CircuitBreaker(name = "naverOpenApiCircuitBreakerConfig" , fallbackMethod = "fallback")
    public FindLowestPriceResponseDto getFindLowestPrice(String type , String sort) {
        return findLowestPriceService.getFindLowestPriceKimchis(type , sort);
    }

    // TODO: 8/5 FallBack Method 구현하기
    public String fallback() {
        return "fallback";
    }
}
