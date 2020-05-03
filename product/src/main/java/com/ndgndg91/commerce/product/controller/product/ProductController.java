package com.ndgndg91.commerce.product.controller.product;

import com.ndgndg91.commerce.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productFindService;

}
