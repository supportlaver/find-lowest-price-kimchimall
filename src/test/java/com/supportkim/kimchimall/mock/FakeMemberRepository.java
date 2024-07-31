package com.supportkim.kimchimall.mock;

import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.service.port.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * In-Memory Repository
 */
public class FakeMemberRepository implements MemberRepository {

    private static Long id = 0L;
    private final List<Member> data = new ArrayList<>();


    @Override
    public Member save(Member member) {
        if (member.getId() == null) {
            Member joinMember = Member.builder()
                    .id(id++)
                    .cart(member.getCart())
                    .address(member.getAddress())
                    .email(member.getEmail())
                    .phoneNumber(member.getPhoneNumber())
                    .loginId(member.getLoginId())
                    .password(member.getPassword())
                    .orders(member.getOrders())
                    .build();
            data.add(joinMember);
            return joinMember;
        } else {
            // 기존에 있던 것을 삭제
            data.removeIf(m -> Objects.equals(m.getId() , member.getId()));
            data.add(member);
            return member;
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        return data.stream().filter(m -> m.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.empty();
    }


}
