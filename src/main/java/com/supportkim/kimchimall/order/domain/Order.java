package com.supportkim.kimchimall.order.domain;

import com.supportkim.kimchimall.delivery.domain.Delivery;
import com.supportkim.kimchimall.delivery.infrastructure.DeliveryEntity;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.infrastructure.MemberEntity;
import com.supportkim.kimchimall.order.infrastructure.OrderStatus;
import com.supportkim.kimchimall.orderkimchi.domain.OrderKimchi;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter @Builder
public class Order {
    private Long id;
    private OrderStatus orderStatus;
    private Delivery delivery;
    private List<OrderKimchi> orderKimchis = new ArrayList<>();
    private Member member;
}
