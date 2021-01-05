package com.aio.allinone.product;

import com.aio.allinone.product.common.StatusType;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ProductService {

    private final MongoTemplate mongoTemplate;
    private static final String productPackageName = "com.aio.allinone.product.";
    private Object result = null;
    private final List<String> errors;

    public ProductService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        errors = new ArrayList<>();
    }

    public ProductResponse getProductList(String product) {
        try {
            Class<?> productClass = Class.forName(productPackageName + product);
            result = mongoTemplate.findAll(productClass);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }

    public ProductResponse findProductBy(String product, String sellerId) {
        try {
            Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
            result = mongoTemplate.find(query, Class.forName(productPackageName + product));
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }

    public ProductResponse registerProduct(LinkedHashMap<String, Object> targetProduct) {
        try {
            String product = targetProduct.get("type").toString();
            mongoTemplate.insert(targetProduct, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }

    public ProductResponse updateProduct(LinkedHashMap<String, Object> targetProduct) {
        try {
            String product = targetProduct.get("type").toString();
            Query query = new Query(Criteria.where("_id").is(targetProduct.get("_id").toString()));
            Update update = new Update();
            targetProduct.keySet().forEach(key -> update.set(key, targetProduct.get(key)));
            mongoTemplate.updateMulti(query, update, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }

    public ProductResponse deleteProduct(String product, String id) {
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            mongoTemplate.remove(query, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }

    public ProductResponse finishProduct(String product, String id) {
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            Update update = new Update();
            update.set("productInfo.statusType", StatusType.IMPOSSIBLE);
            mongoTemplate.updateFirst(query, update, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
        return ProductAdapter.getResponse(result, errors);
    }
}
