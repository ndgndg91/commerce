package com.ndgndg91.commerce.product.domain.option;

import com.ndgndg91.commerce.product.domain.SKU;
import com.ndgndg91.commerce.product.domain.product.vo.Price;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "product_option_bundle")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionBundle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "optionBundleSeqGen")
    @SequenceGenerator(name = "optionBundleSeqGen", sequenceName = "PRODUCT_OPTION_BUNDLE_ID_SEQ", allocationSize = 20)
    private Long optionBundleId;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "optionSKU"))
    private SKU sku;

    @Embedded
    @AttributeOverride(name = "amount", column = @Column(name = "optionExtraPriceAmount"))
    @AttributeOverride(name = "currency", column = @Column(name = "optionExtraPriceCurrency"))
    private Price optionExtraPrice;


    //TODO Parent 와 Child Mapping 을 어떻게 할 것인가?

    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long productId;
}
