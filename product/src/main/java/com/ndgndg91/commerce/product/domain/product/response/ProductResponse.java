package com.ndgndg91.commerce.product.domain.product.response;

import com.ndgndg91.commerce.product.domain.product.vo.Price;
import com.ndgndg91.commerce.product.domain.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class ProductResponse {
    private static final ProductResponse EMPTY = new ProductResponse();
    private long id;
    private String name;
    private Price normalPrice;
    private Price discountPrice;
    private String updatedTime;
    private String createdTime;

    public static ProductResponse convert(Product product) {
        if (product == Product.EMPTY) {
            return EMPTY;
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.id = product.getProductId();
        productResponse.name = product.getProductName();
        productResponse.normalPrice = product.getNormalPrice();
        productResponse.discountPrice = product.getDiscountPrice();
        productResponse.updatedTime = product.getUpdatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        productResponse.createdTime = product.getCreatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return productResponse;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
