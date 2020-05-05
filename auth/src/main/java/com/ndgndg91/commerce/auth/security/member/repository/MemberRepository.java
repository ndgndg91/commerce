package com.ndgndg91.commerce.auth.security.member.repository;

import com.ndgndg91.commerce.auth.security.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        try {
            return Optional.of(em.createQuery("SELECT m FROM Member m WHERE m.id = :email", Member.class)
                    .setParameter("email", email)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Optional<Member> findByUserName(String userName) {
        try {
            return Optional.of(em.createQuery("SELECT m FROM Member m WHERE m.userName = :userName", Member.class)
                    .setParameter("userName", userName)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Member save(Member member){
        em.persist(member);
        return member;
    }

}
