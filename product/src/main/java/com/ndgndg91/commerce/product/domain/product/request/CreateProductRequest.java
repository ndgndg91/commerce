package com.ndgndg91.commerce.product.domain.product.request;

import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
public final class CreateProductRequest {
    private final String productName;
    private final BigDecimal normalPrice;
    private final BigDecimal discountPrice;

    private final Set<Long> categoryIds;

    public CreateProductRequest(
            String productName,
            BigDecimal normalPrice,
            BigDecimal discountPrice,
            Set<Long> categoryIds
    ) {
        com.google.common.base.Preconditions.checkNotNull(productName);
        com.google.common.base.Preconditions.checkNotNull(normalPrice);
        com.google.common.base.Preconditions.checkArgument(normalPrice.compareTo(BigDecimal.ZERO) >= 0);
        if (Objects.nonNull(discountPrice)) {
            com.google.common.base.Preconditions.checkArgument(discountPrice.compareTo(normalPrice) < 0);
            com.google.common.base.Preconditions.checkArgument(discountPrice.compareTo(BigDecimal.ZERO) >= 0);
        }

        this.productName = productName;
        this.normalPrice = normalPrice;
        this.discountPrice = discountPrice;
        this.categoryIds = categoryIds;
    }

    public Product toProduct() {
        return Product
                .builder()
                .name(productName)
                .normalPrice(normalPrice)
                .discountPrice(discountPrice)
                .build();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
