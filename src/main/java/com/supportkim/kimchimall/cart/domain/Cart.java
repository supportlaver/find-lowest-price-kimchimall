package com.supportkim.kimchimall.cart.domain;

import com.supportkim.kimchimall.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Cart {
    private Long id;
    private int quantity;
    private Member member;
}
