package com.ndgndg91.commerce.product.category.service;

import com.ndgndg91.commerce.product.service.category.CategoryService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceTest.class);

    private final CategoryService categoryService;

    public CategoryServiceTest(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    private Long categoryId;
    private String categoryName;
    private Long memberNo;

    private Long second_categoryId;
    private String second_categoryName;


    @BeforeAll
    void setUp() {
        categoryId = 100L;
        categoryName = "상의";
        memberNo = 1L;
        second_categoryId = 200L;
        second_categoryName = "하의";
    }

    @Test
    @Order(1)
    @DisplayName("상의 카테고리 추가")
    public void addTopCategory() throws Exception {
        //given

        //when

        //then
     }

     @Test
     @Order(2)
     @DisplayName("하의 카테고리 추가")
     public void addBottomCategory() throws Exception {
         //given

         //when

         //then
      }

      @Test
      @Order(3)
      @DisplayName("카테고리 목록 조회")
      public void findCategories() throws Exception {
          //given

          //when

          //then
       }

       @Test
       @Order(4)
       @DisplayName("상의 카테고리 조회")
       public void findTopCategory() throws Exception {
           //given

           //when

           //then
        }

        @Test
        @Order(5)
        @DisplayName("하의 카테고리 조회")
        public void findBottomCategory() throws Exception {
            //given

            //when

            //then
         }

         @Test
         @Order(6)
         @DisplayName("상의 카테고리 이름 업데이트")
         public void updateTopCategory() throws Exception {
             //given

             //when

             //then
          }

          @Test
          @Order(7)
          @DisplayName("상의 카테고리 이름 변경 후 카테고리 목록 조회")
          public void findCategoriesAgain() throws Exception {
              //given

              //when

              //then
           }

           @Test
           @Order(8)
           @DisplayName("하의 카테고리 삭제")
           public void deleteBottomCategory() throws Exception {
               //given

               //when

               //then
            }

            @Test
            @Order(9)
            @DisplayName("하의 카테고리 삭제 후 카테고리 목록 조회")
            public void findCategoriesLast() throws Exception {
                //given

                //when

                //then
             }

             @Test
             @Order(10)
             @DisplayName("하의 카테고리 삭제 후 하의 카테고리 조회")
             public void findBottomAfterDelete() throws Exception {
                 //given

                 //when

                 //then
              }

              @Test
              @Order(11)
              @DisplayName("하의 카테고리 삭제 후 하의 카테고리 업데이트 시도")
              public void updateBottomAfterDelete() throws Exception {
                  //given

                  //when

                  //then
               }
}
