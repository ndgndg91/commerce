package com.ndgndg91.commerce.product.domain.category.request;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public final class UpdateCategoryRequest {
    private final Long categoryId;
    private final String categoryName;

    public UpdateCategoryRequest(Long categoryId, String categoryName) {
        com.google.common.base.Preconditions.checkNotNull(categoryId);
        com.google.common.base.Preconditions.checkNotNull(categoryName);
        com.google.common.base.Preconditions.checkArgument(categoryName.getBytes().length < 1000);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
