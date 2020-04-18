package com.ndgndg91.commerce.product.domain;

import com.ndgndg91.commerce.product.domain.vo.Size;
import com.ndgndg91.commerce.product.domain.vo.book.Author;
import com.ndgndg91.commerce.product.domain.vo.Weight;
import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "product_book")
public class Book extends Product {
    @Embedded
    private Author author;
    private String isbn10;
    private String isbn13;
    @Embedded
    private Weight pageCount;
    @Embedded
    private Size size;
    private LocalDate publicationDate;
}
