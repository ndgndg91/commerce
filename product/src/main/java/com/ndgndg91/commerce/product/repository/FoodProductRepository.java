package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Food;
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

    public List<Food> findByPageable(int offset, int limit) {
        return em.createQuery("SELECT f FROM Food f", Food.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
