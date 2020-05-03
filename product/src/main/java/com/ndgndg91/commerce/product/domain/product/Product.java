package com.ndgndg91.commerce.product.domain.product;

import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    @SequenceGenerator(name = "productSeqGen", sequenceName="PRODUCT_ID_SEQ", allocationSize=20)
    private Long id;
    private String name;
    private BigDecimal normalPrice;
    private BigDecimal discountPrice;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long memberNo;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}