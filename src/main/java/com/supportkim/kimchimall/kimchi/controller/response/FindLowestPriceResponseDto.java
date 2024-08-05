package com.supportkim.kimchimall.kimchi.controller.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class FindLowestPriceResponseDto {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<ItemDTO> items;

    @Getter @Builder
    static class ItemDTO {
        private String title;
        private String link;
        private String image;
        private String lprice;
        private String hprice;
        private String mallName;
        private String productId;
        private String productType;
        private String brand;
        private String maker;
        private String category1;
        private String category2;
        private String category3;
        private String category4;
    }
}