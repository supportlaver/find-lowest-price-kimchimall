package com.supportkim.kimchimall.member.controller.port;

import com.supportkim.kimchimall.member.controller.response.MemberResponseDto;
import com.supportkim.kimchimall.member.domain.Member;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;
import static com.supportkim.kimchimall.member.controller.response.MemberResponseDto.*;

public interface MemberService {
    MemberJoinResponse join(MemberJoinRequest memberJoinRequestDto);

    Member findById(Long id);

    MemberLoginResponse login(MemberLoginRequest memberLoginRequestDto);

    Member findByLoginId(String loginId);
}
