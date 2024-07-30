package com.supportkim.kimchimall.common.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supportkim.kimchimall.common.exception.BaseException;
import com.supportkim.kimchimall.common.exception.ErrorCode;
import com.supportkim.kimchimall.common.security.jwt.JwtService;
import com.supportkim.kimchimall.common.security.jwt.TokenMapping;
import com.supportkim.kimchimall.member.controller.response.MemberResponseDto;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.supportkim.kimchimall.member.controller.response.MemberResponseDto.*;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    // ObjectMapper 싱글톤으로 사용하도록 하는게 더 좋아보인다.
    private ObjectMapper om = new ObjectMapper();

    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Member member = (Member) authentication.getPrincipal();

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        TokenMapping token = jwtService.createToken(member.getEmail());
        member.updateRefreshToken(token.getRefreshToken());

        MemberLoginResponse loginResponse = MemberLoginResponse.from(member, token);

        om.writeValue(response.getWriter() , loginResponse);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
