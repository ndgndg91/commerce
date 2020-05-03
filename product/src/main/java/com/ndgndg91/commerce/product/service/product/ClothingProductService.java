package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.product.Clothing;
import com.ndgndg91.commerce.product.repository.product.ClothingProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClothingProduct")
@RequiredArgsConstructor
public class ClothingProductService implements ProductService<Clothing> {
    private final ClothingProductRepository clothingProductRepository;

    @Override
    public List<Clothing> findAllWithPagination(long memberNo, int offset, int limit) {
        return clothingProductRepository.findByPageable(memberNo, offset, limit);
    }
}
