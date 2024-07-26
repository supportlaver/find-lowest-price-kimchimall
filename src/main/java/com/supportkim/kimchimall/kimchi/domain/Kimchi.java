package com.supportkim.kimchimall.kimchi.domain;

import com.supportkim.kimchimall.category.infrastructure.CategoryEntity;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Kimchi {
    private Long id;
    private String name;
    private int price;
    private CategoryEntity category;
}
