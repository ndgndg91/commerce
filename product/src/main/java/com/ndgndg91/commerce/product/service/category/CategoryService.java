package com.ndgndg91.commerce.product.service.category;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.repository.category.CategoryRepository;
import com.ndgndg91.commerce.product.security.domain.JWTAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
@RequestMapping("/categories")
public class  CategoryService {

    private final CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Object> createCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Object> readCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            @PathVariable(required = false) Long categoryId,
            Pageable pageable){
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Object> updateCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ) {
        return ResponseEntity.ok().build();
    }
}
