package com.ndgndg91.commerce.product.domain.option;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "product_option_child")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionChild {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OptionChildSeqGen")
    @SequenceGenerator(name = "optionChildSeqGen", sequenceName = "PRODUCT_OPTION_ID_SEQ", allocationSize = 20)
    private Long optionChildId;
    private String optionChildName;

    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    private long optionParentId;
}
