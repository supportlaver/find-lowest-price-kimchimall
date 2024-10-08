package com.supportkim.kimchimall.member.service;

import com.supportkim.kimchimall.cart.controller.port.CartService;
import com.supportkim.kimchimall.cart.domain.Cart;
import com.supportkim.kimchimall.common.exception.BaseException;
import com.supportkim.kimchimall.common.exception.ErrorCode;
import com.supportkim.kimchimall.member.controller.port.MemberService;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;
import static com.supportkim.kimchimall.member.controller.response.MemberResponseDto.*;

@Service
@RequiredArgsConstructor
@Builder
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public MemberJoinResponse join(MemberJoinRequest request) {
        Cart savedCart = cartService.save(new Cart());
        String encodePassword = passwordEncoder.encode(request.getPassword());
        Member member = memberRepository.save(MemberJoinRequest.toModel(request,savedCart,encodePassword));
        return MemberJoinResponse.from(member);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(ErrorCode.MEMBER_PK_ID_NOT_FOUND));
    }

    @Override
    public MemberLoginResponse login(MemberLoginRequest memberLoginRequestDto) {
        throw new RuntimeException("no development");
    }

    @Override
    public Member findByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new BaseException(ErrorCode.MEMBER_LOGIN_ID_NOT_FOUND));
    }

    @Override
    public Member findByName(String name) {
        return memberRepository.findByName(name).orElseThrow(() -> new BaseException(ErrorCode.MEMBER_NOT_FOUND));

    }
}
