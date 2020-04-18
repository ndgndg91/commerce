package com.ndgndg91.commerce.product.domain.vo;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Embeddable
public class Weight {
    private int value;
    @Enumerated(value = EnumType.STRING)
    private Unit unit;
}
