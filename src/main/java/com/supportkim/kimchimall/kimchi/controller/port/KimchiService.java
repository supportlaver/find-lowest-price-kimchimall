package com.supportkim.kimchimall.kimchi.controller.port;

import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.domain.KimchiType;

public interface KimchiService {
    FindLowestPriceResponseDto getFindLowestPrice(String type , String sort);
}
