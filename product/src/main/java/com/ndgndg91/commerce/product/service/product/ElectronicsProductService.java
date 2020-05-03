package com.ndgndg91.commerce.product.service.product;


import com.ndgndg91.commerce.product.domain.product.Electronics;
import com.ndgndg91.commerce.product.repository.product.ElectronicsProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ElectronicsProduct")
@RequiredArgsConstructor
public class ElectronicsProductService implements ProductService<Electronics> {
    private final ElectronicsProductRepository electronicsProductRepository;

    @Override
    public List<Electronics> findAllWithPagination(long memberNo, int offset, int limit) {
        return electronicsProductRepository.findByPageable(memberNo, offset, limit);
    }
}
