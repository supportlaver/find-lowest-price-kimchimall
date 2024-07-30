package com.supportkim.kimchimall.member.controller.response;

import com.supportkim.kimchimall.common.security.jwt.TokenMapping;
import com.supportkim.kimchimall.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

public class MemberResponseDto {

    @Builder @Getter
    public static class MemberJoinResponse {
        private Long id;
        private String name;

        public static MemberJoinResponse from(Member member) {
            return MemberJoinResponse.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .build();
        }
    }

    @Builder @Getter
    public static class MemberLoginResponse {
        private Long memberId;
        private TokenMapping tokenMapping;
        public static MemberLoginResponse from(Member member , TokenMapping token) {
            return MemberLoginResponse.builder()
                    .memberId(member.getId())
                    .tokenMapping(token)
                    .build();
        }
    }
}
