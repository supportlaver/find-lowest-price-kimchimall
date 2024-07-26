package com.supportkim.kimchimall.member.controller;

import com.supportkim.kimchimall.member.controller.port.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
}
