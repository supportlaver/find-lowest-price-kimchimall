package com.supportkim.kimchimall.member.infrastructure;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.cart.infrastructure.CartEntity;
import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.coupon.domain.Coupon;
import com.supportkim.kimchimall.coupon.infrastructure.CouponEntity;
import com.supportkim.kimchimall.notification.infrastructure.NotificationEntity;
import com.supportkim.kimchimall.order.infrastructure.OrderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;

@Entity
@Table(name = "members")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;
    private Address address;
    private String email;

    @OneToOne(fetch = LAZY)
    private CartEntity cart;

    @OneToMany(cascade = ALL)
    private List<NotificationEntity> notifications = new ArrayList<>();

    @OneToMany(cascade = ALL)
    private List<OrderEntity> orders = new ArrayList<>();
}
