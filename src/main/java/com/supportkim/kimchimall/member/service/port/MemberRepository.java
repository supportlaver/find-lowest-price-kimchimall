package com.supportkim.kimchimall.member.service.port;

import com.supportkim.kimchimall.member.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);
}
