package com.supportkim.kimchimall.member.controller.request;

import com.supportkim.kimchimall.member.infrastructure.Address;
import lombok.Builder;
import lombok.Getter;

public class MemberRequestDto {
    @Builder @Getter
    public static class MemberJoin {
        private String name;
        private String phoneNumber;
        private Address address;
    }
}
