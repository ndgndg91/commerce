package com.ndgndg91.commerce.product.domain.option;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "product_option_name")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionParent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "optionParentSeqGen")
    @SequenceGenerator(name = "optionParentSeqGen", sequenceName = "PRODUCT_OPTION_ID_SEQ", allocationSize = 20)
    private Long optionParentId;
    private String optionParentName;

    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long productId;
}
