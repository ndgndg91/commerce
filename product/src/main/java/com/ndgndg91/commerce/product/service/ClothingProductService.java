package com.ndgndg91.commerce.product.service;

import com.ndgndg91.commerce.product.domain.Clothing;
import com.ndgndg91.commerce.product.repository.ClothingProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClothingProduct")
@RequiredArgsConstructor
public class ClothingProductService implements ProductService<Clothing> {
    private final ClothingProductRepository clothingProductRepository;

    @Override
    public List<Clothing> findAllWithPagination(int offset, int limit) {
        return clothingProductRepository.findByPageable(offset, limit);
    }
}
