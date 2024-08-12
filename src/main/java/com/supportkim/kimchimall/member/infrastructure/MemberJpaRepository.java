package com.supportkim.kimchimall.member.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberEntity , Long> {
    MemberEntity findByLoginId(String loginId);
    MemberEntity findByEmail(String email);
    MemberEntity findByName(String name);
}
