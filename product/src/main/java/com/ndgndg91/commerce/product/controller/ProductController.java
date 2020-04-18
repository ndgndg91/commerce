package com.ndgndg91.commerce.product.controller;

import com.ndgndg91.commerce.product.domain.Product;
import com.ndgndg91.commerce.product.service.ProductTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductTestService productTestService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productTestService.findAll());
    }
}
