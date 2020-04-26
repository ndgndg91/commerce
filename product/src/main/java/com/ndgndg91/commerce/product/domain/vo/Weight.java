package com.ndgndg91.commerce.product.domain.vo;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "product_book_weight")
@Getter
public class Weight {
    @Id
    private Long id;
    private double value;
    @Enumerated(value = EnumType.STRING)
    private WeightUnit unit;
}

