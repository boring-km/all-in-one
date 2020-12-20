package com.aio.allinone.product;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<?> getProductList(String product) {
        return mongoTemplate.findAll(Objects.requireNonNull(ProductType.findProduct(product)));
    }

    public List<?> findProductBy(String product, String sellerId) {
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        return mongoTemplate.find(query, Objects.requireNonNull(ProductType.findProduct(product)));
    }

    public Product registerProduct(String product, Product targetProduct) {
        return mongoTemplate.insert(targetProduct, product);
    }

    public Product updateProduct(String product, Product targetProduct) {
        Class<?> productClass = ProductType.valueOf(product).productClass;
        Query query = new Query(Criteria.where("_id").is(targetProduct.get_id()));
        Object beforeProduct = mongoTemplate.findById(targetProduct.get_id(), productClass);
        JSONObject beforeObj = new JSONObject(Objects.requireNonNull(beforeProduct).toString());
        JSONObject targetObj = new JSONObject(Objects.requireNonNull(targetProduct).toString());
        Update update = new Update();

        while (!beforeObj.isEmpty()) {
            String key = String.valueOf(beforeObj.keys());
            update.set(key, targetObj.get(key));
        }
        mongoTemplate.updateMulti(query, update, productClass);
        return (Product) mongoTemplate.findById(targetProduct.get_id(), productClass);
    }
}
