package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.product.Food;
import com.ndgndg91.commerce.product.repository.product.FoodProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FoodProduct")
@RequiredArgsConstructor
public class FoodProductService implements ProductService<Food> {
    private final FoodProductRepository foodProductRepository;

    @Override
    public List<Food> findAllWithPagination(long memberNo, int offset, int limit) {
        return foodProductRepository.findByPageable(memberNo, offset, limit);
    }
}
