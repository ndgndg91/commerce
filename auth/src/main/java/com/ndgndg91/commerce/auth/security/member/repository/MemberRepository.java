package com.ndgndg91.commerce.auth.security.member.repository;

import com.ndgndg91.commerce.auth.security.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Member> findAll(){
        return em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }
}
