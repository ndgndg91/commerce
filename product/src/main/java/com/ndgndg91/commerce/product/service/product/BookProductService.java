package com.ndgndg91.commerce.product.service.product;

import com.ndgndg91.commerce.product.domain.product.Book;
import com.ndgndg91.commerce.product.repository.product.BookProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookProduct")
@RequiredArgsConstructor
public class BookProductService implements ProductService<Book> {
    private final BookProductRepository bookProductRepository;

    @Override
    public List<Book> findAllWithPagination(long memberNo, int offset, int limit) {
        return bookProductRepository.findByPageable(memberNo, offset, limit);
    }
}
