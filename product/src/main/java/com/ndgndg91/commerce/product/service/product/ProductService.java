package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.category.Category;
import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.repository.product.ProductRepository;
import com.ndgndg91.commerce.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    @Transactional
    public Long createProduct(
            final long memberNo,
            final Product product,
            final Set<Long> categoryIds
            ) {

        List<Category> categories = categoryService.findByIds(memberNo, categoryIds);
        product.createNewProduct(memberNo, categories);
        return productRepository.createProduct(product);
    }

    public Product findById(final long memberNo, final Long productId) {
        return productRepository.findById(memberNo, productId).orElse(Product.EMPTY);
    }
}
