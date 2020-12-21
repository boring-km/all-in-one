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
        return mongoTemplate.findAll(Objects.requireNonNull(ProductType.findProduct(product).productClass));
    }

    public List<?> findProductBy(String product, String sellerId) {
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        return mongoTemplate.find(query, Objects.requireNonNull(ProductType.findProduct(product).productClass));
    }

    public Object registerProduct(String product, Object targetProduct) {
        return mongoTemplate.insert(targetProduct, ProductType.findProduct(product).name());
    }

    public Product updateProduct(String product, Object targetProduct) {
        Class<?> productClass = ProductType.valueOf(product).productClass;
        Query query = new Query(Criteria.where("_id").is(((Product)targetProduct).get_id()));
        JSONObject beforeObj = (Product) mongoTemplate.findById(((Product)targetProduct).get_id(), productClass);
        JSONObject targetObj = new JSONObject(Objects.requireNonNull((Product)targetProduct).toString());
        Update update = new Update();

        if (beforeObj != null) {
            while (!beforeObj.isEmpty()) {
                String key = String.valueOf(beforeObj.keys());
                if (key.equals("_id")) continue;
                update.set(key, targetObj.get(key));
            }
        }
        mongoTemplate.updateMulti(query, update, productClass);
        return (Product) mongoTemplate.findById(((Product)targetProduct).get_id(), productClass);
    }
}
