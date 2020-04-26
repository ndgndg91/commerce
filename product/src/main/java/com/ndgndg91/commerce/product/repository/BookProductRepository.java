package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookProductRepository {

    @PersistenceContext
    private final EntityManager em;

    public List<Book> findByPageable(long memberNo, int offset, int limit){
        return em.createQuery("SELECT b FROM Book b WHERE b.memberNo = :memberNo", Book.class)
                .setParameter("memberNo", memberNo)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
