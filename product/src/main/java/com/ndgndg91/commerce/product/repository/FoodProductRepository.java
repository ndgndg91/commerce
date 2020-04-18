package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodProductRepository extends JpaRepository<Food, Long> {
}
