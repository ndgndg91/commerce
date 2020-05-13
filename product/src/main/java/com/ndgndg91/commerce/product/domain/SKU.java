package com.ndgndg91.commerce.product.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class SKU {
    private String value;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
