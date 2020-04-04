package com.ndgndg91.commerce.auth.security.member.service;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        List<Member> all = memberRepository.findAll();
        log.info("{}", all);
        return all;
    }
}
