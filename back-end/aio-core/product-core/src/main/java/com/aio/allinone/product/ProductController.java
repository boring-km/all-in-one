package com.aio.allinone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
// TODO: 제대로 작동하는지 확인 필요

    @Autowired
    private ProductService productService;

    @GetMapping("/{product}")
    public List<?> getProductList(@PathVariable String product) {
        return productService.getProductList(product);
    }

    @GetMapping("/{product}/{sellerId}")
    public List<?> findProductBy(@PathVariable String product, @PathVariable String sellerId) {
        return productService.findProductBy(product, sellerId);
    }

    @PostMapping("/{product}/register")
    public Product registerProduct(@PathVariable String product, @RequestBody Product targetProduct) {
        return productService.registerProduct(product, targetProduct);
    }

    @PostMapping("/{product}/update")
    public Product updateProduct(@PathVariable String product, @RequestBody Product targetProduct) {
        return productService.updateProduct(product, targetProduct);
    }
}
