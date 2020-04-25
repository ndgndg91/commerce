package com.ndgndg91.commerce.product.service;


import com.ndgndg91.commerce.product.domain.Electronics;
import com.ndgndg91.commerce.product.repository.ElectronicsProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ElectronicsProduct")
@RequiredArgsConstructor
public class ElectronicsProductService implements ProductService<Electronics> {
    private final ElectronicsProductRepository electronicsProductRepository;

    @Override
    public List<Electronics> findAllWithPagination(int offset, int limit) {
        return electronicsProductRepository.findByPageable(offset, limit);
    }
}
