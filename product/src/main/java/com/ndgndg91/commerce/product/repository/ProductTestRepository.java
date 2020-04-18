package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTestRepository extends JpaRepository<Product, Long> {


}
