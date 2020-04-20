package com.ndgndg91.commerce.auth.security.member.repository;

import com.ndgndg91.commerce.auth.security.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Member> findAll(int offset, int limit){
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public Optional<Member> findByEmail(String email) {
        return Optional.ofNullable(em.createQuery("SELECT m FROM Member m WHERE m.id = :email", Member.class)
                .setParameter("email", email)
                .getSingleResult());
    }

    public Optional<Member> findByUserName(String userName) {
        return Optional.ofNullable(em.createQuery("SELECT m FROM Member m WHERE m.userName = :userName", Member.class)
                .setParameter("userName", userName)
                .getSingleResult());
    }

    public Member save(Member member){
        em.persist(member);
        return member;
    }

}
