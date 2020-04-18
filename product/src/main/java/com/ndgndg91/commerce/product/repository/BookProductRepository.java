package com.ndgndg91.commerce.product.repository;

import com.ndgndg91.commerce.product.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookProductRepository extends JpaRepository<Book, Long> {
}
