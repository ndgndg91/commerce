package com.ndgndg91.commerce.product.controller;

import com.ndgndg91.commerce.product.domain.Product;
import com.ndgndg91.commerce.product.domain.ProductType;
import com.ndgndg91.commerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final Map<String, ProductService> productFindService;

    @GetMapping("/products/{productCode}")
    public ResponseEntity<List<Product>> findAll(@PathVariable int productCode){
        String serviceName = ProductType.find(productCode);
        ProductService productProductService = productFindService.get(serviceName);
        List<Product> all = productProductService.findAll();
        return ResponseEntity.ok(all);
    }
}
