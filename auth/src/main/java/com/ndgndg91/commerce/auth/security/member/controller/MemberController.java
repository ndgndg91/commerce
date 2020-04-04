package com.ndgndg91.commerce.auth.security.member.controller;

import com.ndgndg91.commerce.auth.security.common.ApiSuccessResult;
import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<ApiSuccessResult> getAllMembers(){
        log.info("?? what the hell");
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok().body(ApiSuccessResult.wrap(members));
    }
}
