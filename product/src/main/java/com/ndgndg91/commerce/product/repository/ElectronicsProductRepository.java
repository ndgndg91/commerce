package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Electronics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ElectronicsProductRepository {

    @PersistenceContext
    private final  EntityManager em;

    public List<Electronics> findByPageable(int offset, int limit) {
        return em.createQuery("SELECT e FROM Electronics e", Electronics.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
