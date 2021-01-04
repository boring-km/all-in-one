package com.aio.allinone.product;

import com.aio.allinone.product.common.StatusType;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class ProductService {

    private final MongoTemplate mongoTemplate;
    private static final String productPackageName = "com.aio.allinone.product.";

    public ProductService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Object getProductList(String product) {
        JSONObject result = new JSONObject();
        try {
            Class<?> productClass = Class.forName(productPackageName + product);
            return mongoTemplate.findAll(productClass);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            return result.toString();
        }
    }

    public Object findProductBy(String product, String sellerId) {
        JSONObject result = new JSONObject();
        try {
            Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
            return mongoTemplate.find(query, Class.forName(productPackageName + product));
        } catch (Exception e) {
            result.put("error", e.getMessage());
            return result.toString();
        }
    }

    public Object registerProduct(LinkedHashMap<String, Object> targetProduct) {
        JSONObject result = new JSONObject();
        try {
            String product = targetProduct.get("type").toString();
            mongoTemplate.insert(targetProduct, product);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("error", e);
        }
        return result.toString();
    }

    public Object updateProduct(LinkedHashMap<String, Object> targetProduct) {
        JSONObject result = new JSONObject();
        try {
            String product = targetProduct.get("type").toString();
            Query query = new Query(Criteria.where("_id").is(targetProduct.get("_id").toString()));
            Update update = new Update();
            targetProduct.keySet().forEach(key -> update.set(key, targetProduct.get(key)));
            mongoTemplate.updateMulti(query, update, product);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }
        return result.toString();
    }

    public Object deleteProduct(String product, String id) {
        JSONObject result = new JSONObject();
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            mongoTemplate.remove(query, product);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }
        return result.toString();
    }

    public Object finishProduct(String product, String id) {
        JSONObject result = new JSONObject();
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            Update update = new Update();
            update.set("productInfo.statusType", StatusType.IMPOSSIBLE);
            mongoTemplate.updateFirst(query, update, product);
            result.put("result", "success");
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }
        return result.toString();
    }
}
