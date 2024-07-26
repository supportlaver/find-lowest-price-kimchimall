package com.supportkim.kimchimall.member.controller.request;

import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.infrastructure.Address;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MemberRequestDto {
    @Builder @Getter
    public static class MemberJoinRequest {
        private String name;
        private String phoneNumber;
        private Address address;
        private String email;
        private String loginId;
        private String password;

        public static Member toModel(MemberJoinRequest request , Cart cart) {
            return Member.builder()
                    .email(request.getEmail())
                    .name(request.getName())
                    .phoneNumber(request.getPhoneNumber())
                    .address(request.getAddress())
                    .loginId(request.getLoginId())
                    .password(request.getPassword())
                    .orders(new ArrayList<>())
                    .cart(cart)
                    .build();
        }
    }
}
