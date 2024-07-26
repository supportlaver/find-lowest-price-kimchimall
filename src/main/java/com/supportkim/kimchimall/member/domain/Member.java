package com.supportkim.kimchimall.member.domain;


import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.member.infrastructure.Address;
import com.supportkim.kimchimall.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter @Builder
public class Member {
    private Long id;
    private String loginId;
    private String password;
    private Address address;
    private String email;
    private String phoneNumber;
    private Cart cart;
    private List<Order> orders = new ArrayList<>();
}
