package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Clothing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClothingProductRepository {

    @PersistenceContext
    private final EntityManager em;

    public List<Clothing> findByPageable(long memberNo, int offset, int limit) {
        return em.createQuery("SELECT c FROM Clothing c WHERE c.memberNo =:memberNo", Clothing.class)
                .setParameter("memberNo", memberNo)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
