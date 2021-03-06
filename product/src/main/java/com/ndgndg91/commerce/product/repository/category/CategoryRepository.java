package com.ndgndg91.commerce.product.repository.category;

import com.ndgndg91.commerce.product.domain.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {
    private static final String MEMBER_NO_KEY = "memberNo";

    @PersistenceContext
    private final EntityManager em;

    public Long createCategory(Category category) {
        em.persist(category);
        return category.getCategoryId();
    }

    public List<Category> findByMemberNo(long memberNo, int offset, int limit) {
        return em.createQuery("SELECT c FROM Category c WHERE c.memberNo =:memberNo", Category.class)
                .setParameter(MEMBER_NO_KEY, memberNo)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public Optional<Category> findById(long memberNo, Long categoryId) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT c FROM Category c WHERE c.memberNo =:memberNo AND c.categoryId = :categoryId", Category.class)
                    .setParameter(MEMBER_NO_KEY, memberNo)
                    .setParameter("categoryId", categoryId)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }

    public Set<Category> findByIds(long memberNo, Set<Long> ids) {
        return em.createQuery("SELECT c FROM Category c WHERE c.categoryId IN :ids AND c.memberNo = :memberNo", Category.class)
                .setParameter("ids", ids)
                .setParameter(MEMBER_NO_KEY, memberNo)
                .getResultStream().collect(Collectors.toSet());
    }

    public void delete(long memberNo, Long categoryId) {
        em.createQuery("DELETE FROM Category c WHERE c.categoryId = :categoryId AND c.memberNo = :memberNo")
                .setParameter(MEMBER_NO_KEY, memberNo)
                .setParameter("categoryId", categoryId)
                .executeUpdate();
    }
}
