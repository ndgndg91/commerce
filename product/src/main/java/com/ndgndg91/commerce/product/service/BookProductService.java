package com.ndgndg91.commerce.product.service;

import com.ndgndg91.commerce.product.domain.Book;
import com.ndgndg91.commerce.product.repository.BookProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookProduct")
@RequiredArgsConstructor
public class BookProductService implements ProductService<Book> {
    private final BookProductRepository bookProductRepository;

    @Override
    public List<Book> findAll() {
        return bookProductRepository.findAll();
    }
}