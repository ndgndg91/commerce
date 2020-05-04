package com.ndgndg91.commerce.product.controller.category;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.domain.category.Category;
import com.ndgndg91.commerce.product.domain.category.request.CreateCategoryRequest;
import com.ndgndg91.commerce.product.domain.category.request.DeleteCategoryRequest;
import com.ndgndg91.commerce.product.domain.category.request.UpdateCategoryRequest;
import com.ndgndg91.commerce.product.domain.category.response.CategoryResponse;
import com.ndgndg91.commerce.product.security.domain.JWTAuthentication;
import com.ndgndg91.commerce.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;


    /**
     * 새로운 카테고리 생성
     */
    @PostMapping
    public ResponseEntity<Void> createCategory(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @RequestBody final CreateCategoryRequest request
    ){
        Long categoryId = categoryService.createCategory(jwtAuthentication.memberNo, request.getCategoryName());
        return ResponseEntity.created(URI.create("/categories/" + categoryId)).build();
    }

    /**
     * 카테고리 id 로 특정 카테고리 조회
     */
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> readCategory(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @PathVariable final Long categoryId
    )
    {
        Category category = categoryService.findById(jwtAuthentication.memberNo, categoryId);
        CategoryResponse res = CategoryResponse.convert(category);
        return ResponseEntity.ok(res);
    }

    /**
     * 카테고리 목록 조회
     */
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> readCategories(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            final Pageable pageable
    ){
        List<CategoryResponse> categories = categoryService.findByMemberNo(jwtAuthentication.memberNo, pageable)
                .stream()
                .map(CategoryResponse::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    /**
     * 특정 카테고리 업데이트
     */
    @PutMapping
    public ResponseEntity<Void> updateCategory(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @RequestBody final UpdateCategoryRequest request
    ){
        Category category = categoryService
                .updateCategory(jwtAuthentication.memberNo, request.getCategoryId(), request.getCategoryName());
        return ResponseEntity.ok().location(URI.create("/categories/"+ category.getCategoryId())).build();
    }

    /**
     * 특정 카테고리 삭제
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            @RequestBody final DeleteCategoryRequest request
    ) {
        categoryService.deleteCategory(jwtAuthentication.memberNo, request.getCategoryId());
        return ResponseEntity.ok().build();
    }
}
