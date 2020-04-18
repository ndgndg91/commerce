package com.ndgndg91.commerce.product.domain.vo.book;

import lombok.Getter;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Embeddable
public class Author {
    @Column(name = "authorName")
    private String name;
    private String origin;
    private LocalDate birthday;
}
