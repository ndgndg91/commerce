package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.domain.category.Category;
import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.repository.product.ProductRepository;
import com.ndgndg91.commerce.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            final Product request,
            @Nullable final Set<Long> categoryIds
            ) {

        Set<Category> categories = categoryService.findByIds(memberNo, categoryIds);
        request.createNewProduct(memberNo, categories);
        return productRepository.createProduct(request);
    }

    public Product findById(final long memberNo, final Long productId) {
        return productRepository.findById(memberNo, productId).orElse(Product.EMPTY);
    }

    public List<Product> findByMemberNo(final long memberNo, final Pageable pageable) {
        return productRepository.findByMemberNo(memberNo, pageable.offset(), pageable.limit());
    }

    @Transactional
    public Product updateProduct(
            final long memberNo,
            final Product request,
            @Nullable final Set<Long> categoryIds
    ) {
        Product origin = findById(memberNo, request.getProductId());
        Set<Category> categories = categoryService.findByIds(memberNo, categoryIds);
        origin.updateProduct(request.getProductName(), request.getNormalPrice(), request.getDiscountPrice(), categories);
        return origin;
    }

    @Transactional
    public void deleteProduct(final long memberNo, final Long productId) {
        productRepository.deleteProduct(memberNo, productId);
    }
}
