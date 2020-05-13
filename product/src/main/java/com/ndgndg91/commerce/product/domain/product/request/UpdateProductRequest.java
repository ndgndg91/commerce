package com.ndgndg91.commerce.product.domain.product.request;

import com.ndgndg91.commerce.product.domain.product.vo.Currency;
import com.ndgndg91.commerce.product.domain.product.vo.Price;
import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
public final class UpdateProductRequest {
    private final Long productId;
    private final String productName;
    private final BigDecimal normalPriceAmount;
    private final BigDecimal discountPriceAmount;
    private final Set<Long> categoryIds;
    private final Currency currency;

    public UpdateProductRequest(
            Long productId,
            String productName,
            BigDecimal normalPriceAmount,
            BigDecimal discountPriceAmount,
            @Nullable Set<Long> categoryIds,
            String currencyCode) {
        com.google.common.base.Preconditions.checkNotNull(productId);
        com.google.common.base.Preconditions.checkNotNull(productName);
        com.google.common.base.Preconditions.checkNotNull(normalPriceAmount);
        com.google.common.base.Preconditions.checkNotNull(currencyCode);
        com.google.common.base.Preconditions.checkArgument(normalPriceAmount.compareTo(BigDecimal.ZERO) >= 0);
        if (Objects.nonNull(discountPriceAmount)) {
            com.google.common.base.Preconditions.checkArgument(discountPriceAmount.compareTo(normalPriceAmount) < 0);
            com.google.common.base.Preconditions.checkArgument(discountPriceAmount.compareTo(BigDecimal.ZERO) >= 0);
        }

        this.productId = productId;
        this.productName = productName;
        this.normalPriceAmount = normalPriceAmount;
        this.discountPriceAmount = discountPriceAmount;
        this.categoryIds = categoryIds;
        this.currency = Currency.of(currencyCode);
    }

    public Product toProduct() {
        Price aNormalPrice = Price.normalPrice(normalPriceAmount, currency);
        Price aDiscountPrice = Price.discountPrice(discountPriceAmount, currency);
        return Product.builder()
                .productId(productId)
                .productName(productName)
                .normalPrice(aNormalPrice)
                .discountPrice(aDiscountPrice)
                .build();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
