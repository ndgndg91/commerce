package com.ndgndg91.commerce.product.category.service;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.common.page.PageableRequest;
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
import java.util.List;
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

    private Long memberNo;

    private Long _1_productId;
    private String _1_productName;
    private BigDecimal _1_normalPrice;
    private BigDecimal _1_discountPrice;

    private String _2_productName;
    private BigDecimal _2_normalPrice;
    private BigDecimal _2_discountPrice;

    private final Set<Long> categoryIds = new HashSet<>();

    @BeforeAll
    void setUp() {
        memberNo = 1L;
        String saleCategoryName = "세일";
        Long saleCategoryId = categoryService.createCategory(memberNo, saleCategoryName);
        String topCategoryName = "상의";
        Long topCategoryId = categoryService.createCategory(memberNo, topCategoryName);
        categoryIds.add(saleCategoryId);
        categoryIds.add(topCategoryId);

        _1_productName = "구찌-애플-col-power";
        _1_normalPrice = new BigDecimal(720000);
        _1_discountPrice = new BigDecimal(640000);

        _2_productName = "두번째-상품";
        _2_normalPrice = new BigDecimal(65000);
        _2_discountPrice = new BigDecimal(54000);
    }


    @Test
    @Order(1)
    @DisplayName("카테고리에 속한 상품 추가 후 조회")
    public void addProduct() {
        //given
        Product _1_product = Product.builder()
                .name(_1_productName)
                .normalPrice(_1_normalPrice)
                .discountPrice(_1_discountPrice)
                .build();
        _1_productId = productService.createProduct(memberNo, _1_product, categoryIds);
        logger.info("{}", _1_productId);

        //when
        Product product = productService.findById(memberNo, _1_productId);
        logger.info("{}", product);

        //then
        Assertions.assertSame(_1_productId, product.getProductId());
    }

    @Test
    @Order(2)
    @DisplayName("상품 목록 조회")
    public void readProducts() {
        //given
        Pageable pageable = new PageableRequest();

        //when
        List<Product> products = productService.findByMemberNo(memberNo, pageable);

        //then
        logger.info("{}", products);
        Assertions.assertSame(1, products.size());
    }

    @Test
    @Order(3)
    @DisplayName("업데이트 후 상품 조회")
    public void readProductAfterUpdate() {
        //given
        Product update = Product.builder()
                .productId(_1_productId)
                .name("갓뎀왓더헬")
                .normalPrice(new BigDecimal(1000))
                .discountPrice(new BigDecimal(500))
                .build();

        //when
        Product product = productService.updateProduct(memberNo, update, null);

        //then
        Assertions.assertSame(update.getProductId(), product.getProductId());
        Assertions.assertSame(update.getName(), product.getName());
        Assertions.assertSame(update.getNormalPrice(), product.getNormalPrice());
        Assertions.assertSame(update.getDiscountPrice(), product.getDiscountPrice());
        Assertions.assertSame(update.getCategories().size(), product.getCategories().size());
    }

    @Test
    @Order(4)
    @DisplayName("두 번째 상품 추가 후 상품 목록 조회")
    public void readProductsAfterAddProduct() {
        //given
        Product _2_product = Product.builder()
                .name(_2_productName)
                .normalPrice(_2_normalPrice)
                .discountPrice(_2_discountPrice)
                .build();
        Pageable pageable = new PageableRequest();

        //when
        List<Product> productsBeforeAdding = productService.findByMemberNo(memberNo, pageable);
        Long id = productService.createProduct(memberNo, _2_product, categoryIds);
        List<Product> products = productService.findByMemberNo(memberNo, pageable);

        logger.info("{}", productsBeforeAdding);
        logger.info("{}", id);
        logger.info("{}", products);

        //then
        Assertions.assertSame(1, productsBeforeAdding.size());
        Assertions.assertSame(2, products.size());
     }
}
