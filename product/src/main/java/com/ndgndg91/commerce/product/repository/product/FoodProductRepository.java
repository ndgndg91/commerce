package com.ndgndg91.commerce.product.repository.product;

import com.ndgndg91.commerce.product.domain.product.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FoodProductRepository {

    @PersistenceContext
    private final EntityManager em;

    public List<Food> findByPageable(long memberNo, int offset, int limit) {
        return em.createQuery("SELECT f FROM Food f WHERE f.memberNo = :memberNo", Food.class)
                .setParameter("memberNo", memberNo)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
