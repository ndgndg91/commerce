package com.ndgndg91.commerce.product.domain.vo;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Size {
    private int width; //가로
    private int depth; //세로
    private int height; //높이
}
