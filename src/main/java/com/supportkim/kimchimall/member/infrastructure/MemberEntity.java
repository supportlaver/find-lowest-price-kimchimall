package com.supportkim.kimchimall.member.infrastructure;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.cart.infrastructure.CartEntity;
import com.supportkim.kimchimall.common.global.BaseEntity;
import com.supportkim.kimchimall.coupon.domain.Coupon;
import com.supportkim.kimchimall.coupon.infrastructure.CouponEntity;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.notification.infrastructure.NotificationEntity;
import com.supportkim.kimchimall.order.infrastructure.OrderEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static java.util.stream.Collectors.*;

@Entity
@Table(name = "members")
@Getter @Builder
@AllArgsConstructor(access= AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class MemberEntity extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String loginId;
    private String password;
    private Address address;
    private String email;
    private String name;
    private String phoneNumber;

    @OneToMany(cascade = ALL , mappedBy = "member")
    private List<OrderEntity> orders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;


    public static MemberEntity from(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .loginId(member.getLoginId())
                .password(member.getPassword())
                .address(member.getAddress())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .cart(CartEntity.from(member.getCart()))
                .orders(OrderEntity.fromList(member.getOrders()))
                .name(member.getName())
                .build();
    }

    public Member toModel() {
        return Member.builder()
                .id(id)
                .name(name)
                .loginId(loginId)
                .password(password)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(address)
                // 지연로딩 -> could not initialize proxy - no Session 오류 발생
                //.orders(orders.stream().map(OrderEntity::toModel).collect(toList()))
                .build();
    }
}
