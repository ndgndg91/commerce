package com.ndgndg91.commerce.product.domain.category.request;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public final class DeleteCategoryRequest {
    private final Long categoryId;

    public DeleteCategoryRequest(Long categoryId) {
        com.google.common.base.Preconditions.checkNotNull(categoryId);
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
