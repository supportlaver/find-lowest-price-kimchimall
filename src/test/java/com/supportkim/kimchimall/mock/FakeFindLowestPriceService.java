package com.supportkim.kimchimall.mock;

import com.supportkim.kimchimall.kimchi.controller.port.FindLowestPriceService;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;

import java.util.ArrayList;
import java.util.List;

import static com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto.*;

public class FakeFindLowestPriceService implements FindLowestPriceService {


    @Override
    public FindLowestPriceResponseDto getFindLowestPriceKimchis(String type, String sort, int display, int start) {

        List<ItemDto>  itemDtoList = createItemDto(type);


        return builder()
                .start(1)
                .display(10)
                .items(itemDtoList)
                .build();

    }

    private List<ItemDto> createItemDto(String type) {
        List<ItemDto> list = new ArrayList<>();
        return list;
    }
}
