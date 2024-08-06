package com.supportkim.kimchimall.kimchi.controller.port;

import com.supportkim.kimchimall.common.config.FeignConfig;
import com.supportkim.kimchimall.common.exception.NaverApiRecordException;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naver-open-api" , url = "https://openapi.naver.com/v1/search/shop.json",
             configuration = FeignConfig.class)
public interface FindLowestPriceService {

    @GetMapping
    FindLowestPriceResponseDto getFindLowestPriceKimchis(@RequestParam("query") String type,
                                                         @RequestParam("sort") String sort);

}
