package com.supportkim.kimchimall.member.infrastructure;

import com.supportkim.kimchimall.common.exception.BaseException;
import com.supportkim.kimchimall.common.exception.ErrorCode;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberJpaRepository memberJpaRepository;
    @Override
    public Member save(Member member) {
        return memberJpaRepository.save(MemberEntity.from(member)).toModel();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberJpaRepository.findById(id).orElseThrow(() -> new BaseException(ErrorCode.MEMBER_NOT_FOUND))
                .toModel());
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return Optional.ofNullable(memberJpaRepository.findByLoginId(loginId).toModel());
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.ofNullable(memberJpaRepository.findByEmail(email).toModel());
    }

}
