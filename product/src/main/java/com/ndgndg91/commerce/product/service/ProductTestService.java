package com.ndgndg91.commerce.product.service;

import com.ndgndg91.commerce.product.domain.Product;
import com.ndgndg91.commerce.product.repository.ProductTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTestService {

    private final ProductTestRepository productTestRepository;

    public List<Product> findAll(){
        return productTestRepository.findAll();
    }
}
