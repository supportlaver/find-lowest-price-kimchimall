package com.supportkim.kimchimall.kimchi.service;

import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto.*;
import com.supportkim.kimchimall.mock.FakeFindLowestPriceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class KimchiServiceImplTest {

    /**
     * Mock 사용 X
     */
    @Test
    @DisplayName("Naver Open API 를 통해 최저가 상품들을 10개 조회해 올 수 있다.")
    void getLowestPriceKimchi() {
        // given
        String type = "배추김치";
        String sort = "dsc";
        int display = 10;
        int start = 1;
        FakeFindLowestPriceService findLowestPriceService = new FakeFindLowestPriceService();

        // when
         FindLowestPriceResponseDto response =
                 findLowestPriceService.getFindLowestPriceKimchis(type,sort,display,start);

        // TODO: 8/7/24 TEST 작성하기


        // then
        Assertions.assertThat(response.getItems().size()).isEqualTo(10);
    }

}