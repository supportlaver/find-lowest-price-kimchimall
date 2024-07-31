package com.supportkim.kimchimall.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supportkim.kimchimall.common.security.jwt.JwtService;
import com.supportkim.kimchimall.member.controller.port.MemberService;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * MemberLogin 테스트 Mock 사용
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MemberLoginWithMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Autowired
    private JwtService jwtService;

    private final ObjectMapper om = new ObjectMapper();

    @AfterEach
    void delete() {
        memberRepository.deleteAll();
    }

    @Test
    @DisplayName("로그인에 성공하면 JWT가 발급되며 JWT 는 Email 을 기반으로 만들어진다.")
    void 로그인에_성공하면_JWT_가_발급된다() throws Exception {
        //given

        // 회원가입 한 Member
        MemberJoinRequest memberJoinRequest = MemberJoinRequest.builder()
                .loginId("loginId")
                .password("password")
                .email("JIWON@naver.com")
                .name("JIWON")
                .build();

        memberService.join(memberJoinRequest);


        // 로그인 Form
        MemberLoginRequest loginMember = MemberLoginRequest.builder()
                .loginId("loginId")
                .password("password")
                .build();

        Member findMember = memberRepository.findByLoginId(loginMember.getLoginId()).get();

        // 자바 객체 -> JSON : writeValueAsString
        // JSON -> 자바 객체 : readValue
        String loginMemberObjectToJson = om.writeValueAsString(loginMember);
        String accessToken = jwtService.createAccessToken(findMember.getEmail());

        //when + then
        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginMemberObjectToJson))
                .andExpect(jsonPath("$.tokenMapping.accessToken").value(accessToken));
    }
}
