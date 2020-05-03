package com.ndgndg91.commerce.product.domain.category;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categorySeqGen", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 20)
    private long categoryId;
    private String categoryName;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long memberNo;
}
