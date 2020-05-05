package com.ndgndg91.commerce.product.repository.product;

import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    @PersistenceContext
    private final EntityManager em;

    public Long createProduct(Product product) {
        em.persist(product);
        return product.getProductId();
    }

    public Optional<Product> findById(long memberNo, Long productId) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT p FROM Product p WHERE p.productId = :productId AND p.memberNo = :memberNo", Product.class)
                    .setParameter("productId", productId)
                    .setParameter("memberNo", memberNo)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<Product> findByMemberNo(long memberNo, int offset, int limit) {
        return em.createQuery("SELECT p FROM Product p WHERE p.memberNo = :memberNo", Product.class)
                .setParameter("memberNo", memberNo)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public void deleteProduct(long memberNo, Long productId) {
        em.createQuery("DELETE FROM Product p WHERE p.productId = :productId AND p.memberNo = :memberNo")
                .setParameter("productId", productId)
                .setParameter("memberNo", memberNo)
                .executeUpdate();
    }
}
