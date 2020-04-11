package com.ndgndg91.commerce.auth.security.member.service;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.MemberIdentifier;
import com.ndgndg91.commerce.auth.security.member.MemberIdentifierType;
import com.ndgndg91.commerce.auth.security.member.exception.NotExistsMemberException;
import com.ndgndg91.commerce.auth.security.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ndgndg91.commerce.auth.security.member.MemberIdentifierType.EMAIL;

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

    public Member login(MemberIdentifier principal, String credentials) {
        Optional<Member> principalMember;
        principalMember = findByMemberIdentifier(principal);
        if (principalMember.isEmpty()) {
            throw new NotExistsMemberException("존재 하지 않는 Member 입니다.");
        }

        Member loginMember = principalMember.get();
        loginMember.checkPassword(credentials);

        return loginMember;
    }

    private Optional<Member> findByMemberIdentifier(MemberIdentifier principal) {
        if (principal.getType().equals(EMAIL))
            return memberRepository.findByEmail(principal.getId());

        return memberRepository.findByUserName(principal.getId());
    }
}
