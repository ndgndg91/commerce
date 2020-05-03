package com.ndgndg91.commerce.product.service.category;

import com.ndgndg91.commerce.product.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class  CategoryService {

    private final CategoryRepository categoryRepository;
}
