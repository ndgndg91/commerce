package com.ndgndg91.commerce.product.repository.product;

import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
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
}
