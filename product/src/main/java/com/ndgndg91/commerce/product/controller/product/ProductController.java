package com.ndgndg91.commerce.product.controller.product;

import com.ndgndg91.commerce.product.common.page.Pageable;
import com.ndgndg91.commerce.product.domain.product.Product;
import com.ndgndg91.commerce.product.domain.product.request.CreateProductRequest;
import com.ndgndg91.commerce.product.domain.product.request.DeleteProductRequest;
import com.ndgndg91.commerce.product.domain.product.request.UpdateProductRequest;
import com.ndgndg91.commerce.product.domain.product.response.ProductResponse;
import com.ndgndg91.commerce.product.security.domain.JWTAuthentication;
import com.ndgndg91.commerce.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 카테고리와 함께 새로운 상품 생성
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

    /**
     * 상품 목록 조회
     */
    @GetMapping
    public ResponseEntity<List<ProductResponse>> readProducts(
            @AuthenticationPrincipal JWTAuthentication jwtAuthentication,
            Pageable pageable
    )
    {
        List<Product> products = productService.findByMemberNo(jwtAuthentication.memberNo, pageable);
        List<ProductResponse> res = products.stream().map(ProductResponse::convert).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

    /**
     * 특정 상품 업데이트
     */
    @PutMapping
    public ResponseEntity<Void> updateProduct(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @RequestBody final UpdateProductRequest request
    ){
        Product product = productService.updateProduct(jwtAuthentication.memberNo, request.toProduct(), request.getCategoryIds());
        return ResponseEntity.ok().location(URI.create("/products/" + product.getProductId())).build();
    }

    /**
     * 특정 상품 삭제
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(
            @AuthenticationPrincipal final JWTAuthentication jwtAuthentication,
            @RequestBody final DeleteProductRequest request
    ) {
        productService.deleteProduct(jwtAuthentication.memberNo, request.getProductId());
        return ResponseEntity.noContent().build();
    }
}
