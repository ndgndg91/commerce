package com.ndgndg91.commerce.product.domain.category;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySeqGen")
    @SequenceGenerator(name = "categorySeqGen", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 20)
    private long categoryId;
    private String categoryName;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long memberNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId);
    }
}
