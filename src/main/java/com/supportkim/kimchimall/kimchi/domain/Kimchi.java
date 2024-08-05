package com.supportkim.kimchimall.kimchi.domain;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Kimchi {
    private Long id;
    private String name;
    private int price;
    private KimchiType type;
}
