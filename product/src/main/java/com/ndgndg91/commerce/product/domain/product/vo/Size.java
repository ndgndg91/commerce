package com.ndgndg91.commerce.product.domain.product.vo;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "product_book_size")
public class Size {
    @Id
    private Long id;
    private int width; //가로
    private int depth; //세로
    private int height; //높이
    @Enumerated(value = EnumType.STRING)
    private LengthUnit unit;
}
