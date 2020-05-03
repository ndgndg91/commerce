package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.product.Product;

import java.util.List;

public interface ProductService<T extends Product> {
    List<T> findAllWithPagination(long memberNo, int offset, int limit);
}
