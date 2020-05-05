package com.ndgndg91.commerce.product.controller.product;

import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.domain.product.request.CreateProductRequest;
import com.ndgndg91.commerce.product.domain.product.response.ProductResponse;
import com.ndgndg91.commerce.product.security.domain.JWTAuthentication;
import com.ndgndg91.commerce.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 새로운 상품 생성
     */
    @PostMapping
    public ResponseEntity<Void> createProduct(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @RequestBody final CreateProductRequest request
    ){
        Long id = productService.createProduct(jwtAuthentication.memberNo, request.toProduct(), request.getCategoryIds());
        return ResponseEntity.created(URI.create("/products/"+id)).build();
    }

    /**
     * 상품 id 로 특정 상품 조회
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> readProduct(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            @PathVariable Long productId
    )
    {
        Product product = productService.findById(jwtAuthentication.memberNo, productId);
        ProductResponse res = ProductResponse.convert(product);
        return ResponseEntity.ok(res);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteProduct(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication
    ) {
        return ResponseEntity.ok().build();
    }
}
