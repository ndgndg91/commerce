package com.ndgndg91.commerce.product.domain.category.response;

import com.ndgndg91.commerce.product.domain.category.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class CategoryResponse {
    private long id;
    private String name;
    private String updatedTime;
    private String createdTime;

    public static CategoryResponse convert(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.id = category.getCategoryId();
        categoryResponse.name = category.getCategoryName();
        categoryResponse.updatedTime = category.getUpdatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        categoryResponse.createdTime = category.getCreatedTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return categoryResponse;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .toString();
    }
}
