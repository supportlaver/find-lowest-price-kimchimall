package com.supportkim.kimchimall.member.service;

import com.supportkim.kimchimall.cart.service.CartServiceImpl;
import com.supportkim.kimchimall.member.controller.response.MemberResponseDto;
import com.supportkim.kimchimall.member.domain.Member;
import com.supportkim.kimchimall.member.infrastructure.Address;
import com.supportkim.kimchimall.mock.FakeCartRepository;
import com.supportkim.kimchimall.mock.FakeMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.supportkim.kimchimall.member.controller.request.MemberRequestDto.*;
import static com.supportkim.kimchimall.member.controller.response.MemberResponseDto.*;
import static org.assertj.core.api.Assertions.*;

/**
 * 최대한 외부 라이브러리 없이 테스트를 할 것
 */
class MemberServiceImplTest {
    private MemberServiceImpl memberService;
    private CartServiceImpl cartService;
    @BeforeEach
    void init() {
        FakeMemberRepository fakeMemberRepository = new FakeMemberRepository();
        FakeCartRepository fakeCartRepository = new FakeCartRepository();
        this.cartService = CartServiceImpl.builder()
                .cartRepository(fakeCartRepository)
                .build();
        this.memberService = MemberServiceImpl.builder()
                .memberRepository(fakeMemberRepository)
                .cartService(cartService)
                .build();

    }


    @Test
    @DisplayName("회원가입 테스트")
    void 회원은_자체_로그인을_통해_회원가입을_할_수_있다() {
        //given
        // 이름 , 주소 , 전화번호를 받는다.
        String name = "JIWON";
        Address address = Address.builder()
                .rnMgtSn("123-123")
                .emdNo(123)
                .build();
        String phoneNumber = "010-1234-1234";
        MemberJoinRequest memberJoinRequestDto = MemberJoinRequest.builder()
                .address(address)
                .phoneNumber(phoneNumber)
                .name(name)
                .build();

        //when
        MemberJoinResponse savedMember = memberService.join(memberJoinRequestDto);

        //then
        Member findMember = memberService.findById(savedMember.getId());
        assertThat(savedMember.getId()).isEqualTo(findMember.getId());
    }

}