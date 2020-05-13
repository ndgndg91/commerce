package com.ndgndg91.commerce.product.domain.product.vo;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;

@Getter
public enum  Currency {
    KRW,
    USD;

    public static Currency of(String aCurrencyCode) {
        return Arrays.stream(Currency.values())
                .filter(currency -> currency.name().equals(aCurrencyCode))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
