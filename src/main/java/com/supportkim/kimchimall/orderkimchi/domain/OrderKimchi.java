package com.supportkim.kimchimall.orderkimchi.domain;

import com.supportkim.kimchimall.kimchi.domain.Kimchi;
import com.supportkim.kimchimall.kimchi.infrastructure.KimchiEntity;
import com.supportkim.kimchimall.order.domain.Order;
import com.supportkim.kimchimall.order.infrastructure.OrderEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import static jakarta.persistence.FetchType.LAZY;

@Getter @Builder
public class OrderKimchi {
    private Long id;
    private int orderPrice;
    private int quantity;
    private Order order;
    private Kimchi kimchi;
}
