package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingProductRepository extends JpaRepository<Clothing, Long> {
}
