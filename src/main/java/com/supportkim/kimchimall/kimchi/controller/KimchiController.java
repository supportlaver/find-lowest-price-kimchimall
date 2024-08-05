package com.supportkim.kimchimall.kimchi.controller;

import com.supportkim.kimchimall.common.global.BaseResponse;
import com.supportkim.kimchimall.kimchi.controller.port.KimchiService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KimchiController {

    private final KimchiService kimchiService;

    @GetMapping("/lowest-price")
    public ResponseEntity<BaseResponse<FindLowestPriceResponseDto>> getLowestPrice(
            @RequestParam("type") String type ,
            @RequestParam("sort") String sort) {

        return ResponseEntity.ok().body(new BaseResponse<>(kimchiService.getFindLowestPrice(type,sort)));
    }

}
