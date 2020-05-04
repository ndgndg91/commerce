package com.ndgndg91.commerce.product.domain.category.request;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@NoArgsConstructor
public final class UpdateCategoryRequest {
    private Long categoryId;
    private String categoryName;

    public UpdateCategoryRequest(Long categoryId, String categoryName) {
        com.google.common.base.Preconditions.checkNotNull(categoryId);
        com.google.common.base.Preconditions.checkNotNull(categoryName);
        com.google.common.base.Preconditions.checkArgument(categoryName.getBytes().length < 1000);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
