package com.supportkim.kimchimall.coupon.infrastructure;

import jakarta.persistence.*;

@Entity
@Table(name = "coupons")
public class CouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;
}
