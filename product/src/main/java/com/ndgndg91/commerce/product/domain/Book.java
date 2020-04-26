package com.ndgndg91.commerce.product.domain;

import com.ndgndg91.commerce.product.domain.vo.Size;
import com.ndgndg91.commerce.product.domain.vo.Weight;
import com.ndgndg91.commerce.product.domain.vo.book.Author;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "product_book")
public class Book extends Product {
    @OneToOne
    @PrimaryKeyJoinColumn
    private Author author;
    private String isbn10;
    private String isbn13;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Weight weight;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Size size;
    private LocalDate publicationDate;
}
