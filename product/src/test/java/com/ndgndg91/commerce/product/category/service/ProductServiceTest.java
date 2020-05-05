package com.ndgndg91.commerce.product.category.service;

import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.service.category.CategoryService;
import com.ndgndg91.commerce.product.service.product.ProductService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    private Long topCategoryId;
    private String topCategoryName;
    private Long saleCategoryId;
    private String saleCategoryName;

    private Long memberNo;

    private Product _1_product;
    private String _1_productName;
    private BigDecimal _1_normalPrice;
    private BigDecimal _1_discountPrice;

    private final Set<Long> categoryIds = new HashSet<>();

    @BeforeAll
    void setUp(){
        memberNo = 1L;
        saleCategoryName = "세일";
        saleCategoryId = categoryService.createCategory(memberNo, saleCategoryName);
        topCategoryName = "상의";
        topCategoryId = categoryService.createCategory(memberNo, topCategoryName);
        categoryIds.add(saleCategoryId);
        categoryIds.add(topCategoryId);

        _1_productName = "구찌-애플-col-power";
        _1_normalPrice = new BigDecimal(720000);
        _1_discountPrice = new BigDecimal(640000);
    }


    @Test
    @Order(1)
    @DisplayName("카테고리에 속한 상품 추가 후 조회")
    public void addProduct() {
        //given
        _1_product = Product.builder()
                .name(_1_productName)
                .normalPrice(_1_normalPrice)
                .discountPrice(_1_discountPrice)
                .build();
        Long id = productService.createProduct(memberNo, _1_product, categoryIds);
        logger.info("{}", id);

        //when
        Product product = productService.findById(memberNo, id);
        logger.info("{}", product);

        //then
        Assertions.assertSame(id, product.getProductId());
     }
}
