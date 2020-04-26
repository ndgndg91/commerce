package com.ndgndg91.commerce.product.service;

import com.ndgndg91.commerce.product.domain.Product;

import java.util.List;

public interface ProductService<T extends Product> {
    List<T> findAllWithPagination(long memberNo, int offset, int limit);
}
