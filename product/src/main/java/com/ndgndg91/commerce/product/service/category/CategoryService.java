package com.ndgndg91.commerce.product.service.category;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.domain.category.Category;
import com.ndgndg91.commerce.product.exception.NotFoundException;
import com.ndgndg91.commerce.product.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class  CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long createCategory(final long memberNo, final String categoryName) {
        Category category = Category.createCategory(categoryName, memberNo);
        return categoryRepository.createCategory(category);
    }

    public List<Category> findByMemberNo(final long memberNo, final Pageable pageable) {
        return categoryRepository.findByMemberNo(memberNo, pageable.offset(), pageable.limit());
    }

    public Category findById(final long memberNo, final Long categoryId) {
        return categoryRepository.findById(memberNo, categoryId).orElse(Category.EMPTY);
    }

    public Set<Category> findByIds(final long memberNo, final Set<Long> categoryIds) {
        return categoryRepository.findByIds(memberNo, categoryIds);
    }

    @Transactional
    public Category updateCategory(final long memberNo, final Long categoryId, final String categoryName) {
        Category existsCategory = categoryRepository.findById(memberNo, categoryId).orElseThrow(NotFoundException::new);

        existsCategory.updateCategoryName(categoryName);
        return existsCategory;
    }

    @Transactional
    public void deleteCategory(long memberNo, Long categoryId) {
        categoryRepository.delete(memberNo, categoryId);
    }
}
