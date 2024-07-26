package com.supportkim.kimchimall.member.controller.port;

import com.supportkim.kimchimall.member.controller.request.MemberRequestDto;
import com.supportkim.kimchimall.member.domain.Member;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;

public interface MemberService {
    Member join(MemberJoin memberJoinDto);

    Member findById(Long id);
}
