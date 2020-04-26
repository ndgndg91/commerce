package com.ndgndg91.commerce.product.domain.vo.book;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "product_book_author")
public class Author {
    @Id
    private Long id;
    @Column(name = "authorName")
    private String name;
    private String origin;
    private LocalDate birthday;
}
