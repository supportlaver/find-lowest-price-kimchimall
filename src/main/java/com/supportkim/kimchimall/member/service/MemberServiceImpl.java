package com.supportkim.kimchimall.member.service;

import com.supportkim.kimchimall.common.exception.BaseException;
import com.supportkim.kimchimall.common.exception.ErrorCode;
import com.supportkim.kimchimall.member.controller.port.MemberService;
import com.supportkim.kimchimall.member.controller.request.MemberRequestDto;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;

@Service
@RequiredArgsConstructor
@Builder
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member join(MemberJoin memberJoinDto) {
        throw new RuntimeException("not developed");
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
