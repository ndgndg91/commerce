package com.ndgndg91.commerce.product.domain.product.vo;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Embeddable
public class Price {
    private final BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private final Currency currency;

    protected Price(){
        this.amount = null;
        this.currency = null;
    }

    protected Price(BigDecimal aAmount, Currency aCurrency) {
        this.amount = aAmount;
        this.currency = aCurrency;
    }

    protected Price(BigDecimal aAmount, String aCurrencyCode) {
        this.amount = aAmount;
        this.currency = Currency.of(aCurrencyCode);
    }

    public static Price normalPrice(BigDecimal aAmount, Currency aCurrency) {
        return new Price(aAmount, aCurrency);
    }

    public static Price normalPrice(BigDecimal aAmount, String aCurrencyCode) {
        return new Price(aAmount, aCurrencyCode);
    }

    public static Price discountPrice(BigDecimal aAmount, Currency aCurrency) {
        return new Price(aAmount, aCurrency);
    }

    public static Price discountPrice(BigDecimal aAmount, String aCurrencyCode) {
        return new Price(aAmount, aCurrencyCode);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
