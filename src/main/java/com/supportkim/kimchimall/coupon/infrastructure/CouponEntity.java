package com.supportkim.kimchimall.coupon.infrastructure;

import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.member.infrastructure.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.*;

@Entity
@Table(name = "coupons")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_id")
    private Long id;
    // 쿠폰 이름
    private String name;

    private int discountRate;

    @Enumerated(value = STRING)
    private CouponStatus couponStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
