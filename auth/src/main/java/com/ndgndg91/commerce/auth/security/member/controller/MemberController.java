package com.ndgndg91.commerce.auth.security.member.controller;

import com.ndgndg91.commerce.auth.security.common.page.Pageable;
import com.ndgndg91.commerce.auth.security.member.request.CreateMemberRequest;
import com.ndgndg91.commerce.auth.security.member.response.MemberToFront;
import com.ndgndg91.commerce.auth.security.member.service.MemberService;
import com.ndgndg91.commerce.auth.security.security.JWTAuthentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberToFront>> getAllMembers(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            Pageable pageable){
        log.info("{}", jwtAuthentication);
        log.info("{}, {}", pageable.offset(), pageable.limit());
        List<MemberToFront> members = memberService.getAllMembers(pageable.offset(), pageable.limit());
        return ResponseEntity.ok()
                .header("X-TOTAL-COUNT", String.valueOf(members.size()))
                .body(members);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody final CreateMemberRequest request){
        long id = memberService.signUp(request.toMember());
        URI memberUri = URI.create("/member/"+id);
        return ResponseEntity.created(memberUri).build();
    }
}
