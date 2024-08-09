package com.application.productservicepart.controller;

import com.application.productservicepart.entity.Product;
import com.application.productservicepart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/purchase-product")
    public boolean addProduct(@RequestBody Product product) {
        System.out.println(product);
        return productService.addProduct(product);
    }
}
