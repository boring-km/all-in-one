package com.aio.allinone.product;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    private final MongoTemplate mongoTemplate;

    public ProductService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<?> getProductList(String product) {
        return mongoTemplate.findAll(Objects.requireNonNull(ProductType.findProduct(product).productClass));
    }

    public List<?> findProductBy(String product, String sellerId) {
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        return mongoTemplate.find(query, Objects.requireNonNull(ProductType.findProduct(product).productClass));
    }

    public LinkedHashMap<String, Object> registerProduct(String product, LinkedHashMap<String, Object> targetProduct) {
        return mongoTemplate.insert(targetProduct, ProductType.findProduct(product).name());
    }

    public String updateProduct(String product, LinkedHashMap<String, Object> targetProduct) {
        try {
            Class<?> productClass = ProductType.valueOf(product).productClass;
            Query query = new Query(Criteria.where("_id").is(targetProduct.get("_id").toString()));
            Update update = new Update();
            targetProduct.keySet().forEach(key -> update.set(key, targetProduct.get(key)));
            mongoTemplate.updateMulti(query, update, productClass);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
