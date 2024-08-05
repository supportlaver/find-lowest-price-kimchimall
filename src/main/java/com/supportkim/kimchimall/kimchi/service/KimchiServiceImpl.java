package com.supportkim.kimchimall.kimchi.service;

import com.supportkim.kimchimall.kimchi.controller.port.FindLowestPriceService;
import com.supportkim.kimchimall.kimchi.controller.port.KimchiService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.domain.KimchiType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KimchiServiceImpl implements KimchiService {

    private final FindLowestPriceService findLowestPriceService;

    @Override
    public FindLowestPriceResponseDto getFindLowestPrice(String type , String sort) {
        return findLowestPriceService.getFindLowestPriceKimchis(type , sort);
    }

}
