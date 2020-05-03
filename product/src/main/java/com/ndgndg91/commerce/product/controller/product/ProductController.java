package com.ndgndg91.commerce.product.controller.product;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.security.domain.JWTAuthentication;
import com.ndgndg91.commerce.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productFindService;

    @PostMapping
    public ResponseEntity<Object> createCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> readCategory(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            @PathVariable(required = false) Long productId,
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
