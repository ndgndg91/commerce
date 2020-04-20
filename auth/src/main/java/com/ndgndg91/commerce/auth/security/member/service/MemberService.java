package com.ndgndg91.commerce.auth.security.member.service;

import com.ndgndg91.commerce.auth.security.member.Member;
import com.ndgndg91.commerce.auth.security.member.MemberIdentifier;
import com.ndgndg91.commerce.auth.security.member.exception.NotExistsMemberException;
import com.ndgndg91.commerce.auth.security.member.repository.MemberRepository;
import com.ndgndg91.commerce.auth.security.member.request.CreateMemberRequest;
import com.ndgndg91.commerce.auth.security.member.response.MemberToFront;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ndgndg91.commerce.auth.security.member.MemberIdentifierType.EMAIL;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberToFront> getAllMembers(int offset, int limit){
        List<Member> all = memberRepository.findAll(offset, limit);
        log.info("{}", all);
        return all.stream()
                .map(MemberToFront::transform)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Transactional
    public Member login(MemberIdentifier principal, String credentials) {
        Optional<Member> principalMember;
        principalMember = findByMemberIdentifier(principal);
        if (principalMember.isEmpty()) {
            throw new NotExistsMemberException("존재 하지 않는 Member 입니다.");
        }

        Member loginMember = principalMember.get();
        loginMember.checkPassword(credentials);
        loginMember.increaseLoginCount();

        return loginMember;
    }

    private Optional<Member> findByMemberIdentifier(MemberIdentifier principal) {
        if (principal.getType().equals(EMAIL))
            return memberRepository.findByEmail(principal.getId());

        return memberRepository.findByUserName(principal.getId());
    }

    public long signUp(CreateMemberRequest request) {
        Member member = request.toMember();
        Member signUpMember = memberRepository.save(member);
        return signUpMember.getMemberNo();
    }
}
