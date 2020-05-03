package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllWithPagination(long memberNo, int offset, int limit){
        return Collections.emptyList();
    }
}
