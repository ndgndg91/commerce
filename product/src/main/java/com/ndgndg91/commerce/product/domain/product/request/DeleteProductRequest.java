package com.ndgndg91.commerce.product.domain.product.request;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public final class DeleteProductRequest {
    private final Long productId;

    public DeleteProductRequest(Long productId) {
        com.google.common.base.Preconditions.checkNotNull(productId);
        this.productId = productId;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}

