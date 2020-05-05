package com.ndgndg91.commerce.product.domain.product;

import com.ndgndg91.commerce.product.domain.category.Category;
import lombok.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Product {
    public static final Product EMPTY = new Product();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeqGen")
    @SequenceGenerator(name = "productSeqGen", sequenceName="PRODUCT_ID_SEQ", allocationSize=20)
    private Long productId;
    private String name;
    private BigDecimal normalPrice;
    private BigDecimal discountPrice;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long memberNo;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
    @JoinTable(name="category_product", joinColumns=@JoinColumn(name="productId"), inverseJoinColumns=@JoinColumn(name="categoryId"))
    private final Set<Category> categories = new HashSet<>();

    public void createNewProduct(long memberNo, List<Category> categories) {
        this.memberNo = memberNo;
        this.categories.addAll(categories);
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .toString();
    }
}
