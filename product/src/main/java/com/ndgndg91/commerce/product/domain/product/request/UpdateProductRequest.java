package com.ndgndg91.commerce.product.domain.product.request;

import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class UpdateProductRequest {
    private Long productId;
    private String productName;
    private BigDecimal normalPrice;
    private BigDecimal discountPrice;
    private Set<Long> categoryIds;

    public UpdateProductRequest(
            Long productId,
            String productName,
            BigDecimal normalPrice,
            BigDecimal discountPrice,
            @Nullable Set<Long> categoryIds) {
        com.google.common.base.Preconditions.checkNotNull(productId);
        com.google.common.base.Preconditions.checkNotNull(productName);
        com.google.common.base.Preconditions.checkNotNull(normalPrice);
        com.google.common.base.Preconditions.checkArgument(normalPrice.compareTo(BigDecimal.ZERO) >= 0);
        if (Objects.nonNull(discountPrice)) {
            com.google.common.base.Preconditions.checkArgument(discountPrice.compareTo(normalPrice) < 0);
            com.google.common.base.Preconditions.checkArgument(discountPrice.compareTo(BigDecimal.ZERO) >= 0);
        }

        this.productId = productId;
        this.productName = productName;
        this.normalPrice = normalPrice;
        this.discountPrice = discountPrice;
        this.categoryIds = categoryIds;
    }

    public Product toProduct() {
        return Product.builder()
                .productId(productId)
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
