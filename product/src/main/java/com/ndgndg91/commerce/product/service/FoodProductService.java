package com.ndgndg91.commerce.product.service;

import com.ndgndg91.commerce.product.domain.Food;
import com.ndgndg91.commerce.product.repository.FoodProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FoodProduct")
@RequiredArgsConstructor
public class FoodProductService implements ProductService<Food> {
    private final FoodProductRepository foodProductRepository;

    @Override
    public List<Food> findAll() {
        return foodProductRepository.findAll();
    }
}
