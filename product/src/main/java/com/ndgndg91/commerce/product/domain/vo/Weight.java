package com.ndgndg91.commerce.product.domain.vo;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Weight {
    private int value;
    private Unit unit;
}
