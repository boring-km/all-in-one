package com.aio.allinone.product;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product}")
    public List<?> getProductList(@PathVariable String product) {
        return productService.getProductList(product);
    }

    @GetMapping("/{product}/{sellerId}")
    public List<?> findProductBy(@PathVariable String product, @PathVariable String sellerId) {
        return productService.findProductBy(product, sellerId);
    }

    @PutMapping("/{product}/register")
    public Object registerProduct(@PathVariable String product, @RequestBody LinkedHashMap<String, Object>  targetProduct) {
        return productService.registerProduct(product, targetProduct);
    }

    @PatchMapping("/{product}/update")
    public String updateProduct(@PathVariable String product, @RequestBody LinkedHashMap<String, Object> targetProduct) {
        return productService.updateProduct(product, targetProduct);
    }
}
