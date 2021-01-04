package com.aio.allinone.product;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{product}")
    public Object getProductList(@PathVariable String product) {
        return productService.getProductList(product);
    }

    @GetMapping("/product/{product}/{sellerId}")
    public Object findProductBy(@PathVariable String product, @PathVariable String sellerId) {
        return productService.findProductBy(product, sellerId);
    }

    @PutMapping("/product/register")
    public Object registerProduct(@RequestBody LinkedHashMap<String, Object>  targetProduct) {
        return productService.registerProduct(targetProduct);
    }

    @PatchMapping("/product/update")
    public Object updateProduct(@RequestBody LinkedHashMap<String, Object> targetProduct) {
        return productService.updateProduct(targetProduct);
    }

    @PatchMapping("/product/finish/{product}/{id}")
    public Object finishProduct(@PathVariable String product, @PathVariable String id) {
        return productService.finishProduct(product, id);
    }

    @DeleteMapping("/product/delete/{product}/{id}")
    public Object deleteProduct(@PathVariable String product, @PathVariable String id) {
        return productService.deleteProduct(product, id);
    }
}
