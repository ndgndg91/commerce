package com.ndgndg91.commerce.product.category.service;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.common.page.PageableRequest;
import com.ndgndg91.commerce.product.domain.category.Category;
import com.ndgndg91.commerce.product.exception.NotFoundException;
import com.ndgndg91.commerce.product.service.category.CategoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceTest.class);

    @Autowired
    private CategoryService categoryService;

    private String topCategoryName;
    private String bottomCategoryName;
    private Long memberNo;

    private Long topCategoryId;
    private Long bottomCategoryId;

    private String toBeTopCategoryName;
    private String toBeBottomCategoryName;

    @BeforeAll
    void setUp() {
        topCategoryName = "상의";
        memberNo = 1L;
        bottomCategoryName = "하의";
        toBeTopCategoryName = "_상의_";
        toBeBottomCategoryName = "_하의_";
    }

    @Test
    @Order(1)
    @DisplayName("상의 카테고리 추가")
    public void addTopCategory() throws Exception {
        topCategoryId = categoryService.createCategory(memberNo, topCategoryName);
        logger.info("{}", topCategoryId);
    }

    @Test
    @Order(2)
    @DisplayName("하의 카테고리 추가")
    public void addBottomCategory() throws Exception {
        bottomCategoryId = categoryService.createCategory(memberNo, bottomCategoryName);
        logger.info("{}", bottomCategoryId);
    }

    @Test
    @Order(3)
    @DisplayName("카테고리 목록 조회")
    public void findCategories() throws Exception {
        //given
        Pageable pageable = new PageableRequest();

        //when
        List<Category> categories = categoryService.findByMemberNo(memberNo, pageable);

        //then
        logger.info("{}", categories);
        Assertions.assertThat(categories.size()).isNotEqualTo(0);
        Assertions.assertThat(categories.size()).isEqualTo(2);
    }

    @Test
    @Order(4)
    @DisplayName("상의 카테고리 조회")
    public void findTopCategory() throws Exception {
        Category topCategory = categoryService.findById(memberNo, topCategoryId);

        Assertions.assertThat(topCategory.getCategoryId()).isEqualTo(topCategoryId);
        Assertions.assertThat(topCategory.getCategoryName()).isEqualTo(topCategoryName);
    }

    @Test
    @Order(5)
    @DisplayName("하의 카테고리 조회")
    public void findBottomCategory() throws Exception {
        Category bottomCategory = categoryService.findById(memberNo, bottomCategoryId);

        Assertions.assertThat(bottomCategory.getCategoryId()).isEqualTo(bottomCategoryId);
        Assertions.assertThat(bottomCategory.getCategoryName()).isEqualTo(bottomCategoryName);
    }

    @Test
    @Order(6)
    @DisplayName("상의 카테고리 이름 업데이트")
    public void updateTopCategory() throws Exception {
        Category updatedTopCategory = categoryService.updateCategory(memberNo, topCategoryId, toBeTopCategoryName);

        logger.info("{}", updatedTopCategory);

        Assertions.assertThat(updatedTopCategory.getCategoryName()).isNotEqualTo(topCategoryName);
        Assertions.assertThat(updatedTopCategory.getCategoryName()).isEqualTo(toBeTopCategoryName);
    }

    @Test
    @Order(7)
    @DisplayName("상의 카테고리 이름 변경 후 카테고리 목록 조회")
    public void findCategoriesAgain() throws Exception {
        //given
        Pageable pageable = new PageableRequest();

        //when
        List<Category> categories = categoryService.findByMemberNo(memberNo, pageable);
        Map<Long, Category> categoryMap = categories.stream().collect(Collectors.toMap(Category::getCategoryId, Function.identity()));

        //then
        logger.info("{}", categories);
        Assertions.assertThat(categories.size()).isNotEqualTo(0);
        Assertions.assertThat(categories.size()).isEqualTo(2);
        Assertions.assertThat(categoryMap.get(topCategoryId).getCategoryName()).isNotEqualTo(topCategoryName);
        Assertions.assertThat(categoryMap.get(topCategoryId).getCategoryName()).isEqualTo(toBeTopCategoryName);
    }

    @Test
    @Order(8)
    @DisplayName("하의 카테고리 삭제")
    public void deleteBottomCategory() throws Exception {
        categoryService.deleteCategory(memberNo, bottomCategoryId);
    }

    @Test
    @Order(9)
    @DisplayName("하의 카테고리 삭제 후 카테고리 목록 조회")
    public void findCategoriesLast() throws Exception {
        //given
        Pageable pageable = new PageableRequest();

        //when
        List<Category> categories = categoryService.findByMemberNo(memberNo, pageable);

        //then
        logger.info("{}", categories);
        Assertions.assertThat(categories.size()).isNotEqualTo(0);
        Assertions.assertThat(categories.size()).isEqualTo(1);
        Assertions.assertThat(categories.get(0).getCategoryName()).isEqualTo(toBeTopCategoryName);
    }

    @Test
    @Order(10)
    @DisplayName("하의 카테고리 삭제 후 하의 카테고리 조회")
    public void findBottomAfterDelete() throws Exception {
        Category deletedBottomCategory = categoryService.findById(memberNo, bottomCategoryId);

        logger.info("{}", deletedBottomCategory);
        Assertions.assertThat(deletedBottomCategory.getCategoryId()).isEqualTo(0);
        Assertions.assertThat(deletedBottomCategory).isEqualTo(Category.EMPTY);
    }

    @Test
    @Order(11)
    @DisplayName("하의 카테고리 삭제 후 하의 카테고리 업데이트 시도")
    public void updateBottomAfterDelete() throws Exception {
        org.junit.jupiter.api.Assertions.assertThrows(NotFoundException.class, () -> {
            Category maybeEmpty = categoryService.updateCategory(memberNo, bottomCategoryId, toBeBottomCategoryName);
            logger.info("{}", maybeEmpty);
        });
    }
}
