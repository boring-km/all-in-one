package com.aio.allinone.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
// TODO: 제대로 작동하는지 확인 필요
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/{product}")
    public List<?> getProductList(@PathVariable String product) {
        return mongoTemplate.findAll(Objects.requireNonNull(ProductType.findProduct(product)));
    }

    @GetMapping("/{product}/{sellerId}")
    public List<?> findProductBy(@PathVariable String product, @PathVariable String sellerId) {
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        return mongoTemplate.find(query, Objects.requireNonNull(ProductType.findProduct(product)));
    }

    @PostMapping("/register/{product}")
    public Product registerProduct(@PathVariable String product, @RequestBody Product targetProduct) {
        return mongoTemplate.insert(targetProduct, product);
    }
}
