package com.aio.allinone.product;

import com.aio.allinone.product.common.StatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MongoTemplate mongoTemplate;
    private static final String productPackageName = "com.aio.allinone.product.";
    private Object result = null;
    private final List<String> errors;

    public ProductService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        errors = new ArrayList<>();
    }

    /**
     * 해당 제품군에 속하는 리스트를 반환
     *
     * @param product 제품 구분
     */
    public ProductResponse getProductList(String product) {
        try {
            Class<?> productClass = Class.forName(productPackageName + product);
            result = mongoTemplate.findAll(productClass);
        } catch (Exception e) {
            errors.add(e.getMessage());
            logger.error("Product 조회 에러");
        }
        return ProductAdapter.getResponse(result, errors);
    }

    /**
     * 해당 판매자의 제품정보 반환
     *
     * @param product 제품 구분
     * @param sellerId 판매자 ID
     */
    public ProductResponse findProductBy(String product, String sellerId) {
        try {
            Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
            result = mongoTemplate.find(query, Class.forName(productPackageName + product));
        } catch (Exception e) {
            errors.add(e.getMessage());
            logger.error("판매자가 업로드한 제품 조회 에러");
        }
        return ProductAdapter.getResponse(result, errors);
    }

    /**
     * 제품 정보를 등록한다.
     *
     * @param targetProduct 등록할 제품 정보
     */
    public ProductResponse registerProduct(LinkedHashMap<String, Object> targetProduct) {
        try {
            String product = targetProduct.get("type").toString();
            mongoTemplate.insert(targetProduct, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
            logger.error("판매자의 제품 업로드 실패 에러");
        }
        return ProductAdapter.getResponse(result, errors);
    }

    /**
     * 제품 정보를 수정한다.
     *
     * @param targetProduct 수정할 제품 정보
     */
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
            logger.error("판매자의 제품 정보 수정 실패 에러");
        }
        return ProductAdapter.getResponse(result, errors);
    }

    /**
     * 해당 제품을 삭제한다.
     *
     * @param product 제품 구분
     * @param id 제품 ID
     */
    public ProductResponse deleteProduct(String product, String id) {
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            mongoTemplate.remove(query, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
            logger.error(String.format("판매자의 제품 제거 실패 에러 (해당 제품 id: %s)", id));
        }
        return ProductAdapter.getResponse(result, errors);
    }

    /**
     * 해당 제품을 마감처리한다.
     *
     * @param product 제품 구분
     * @param id 제품 ID
     */
    public ProductResponse finishProduct(String product, String id) {
        try {
            Query query = new Query(Criteria.where("_id").is(id));
            Update update = new Update();
            update.set("productInfo.statusType", StatusType.IMPOSSIBLE);
            mongoTemplate.updateFirst(query, update, product);
            result = "success";
        } catch (Exception e) {
            errors.add(e.getMessage());
            logger.error(String.format("판매자의 제품 마감 실패 에러 (해당 제품 id: %s)", id));
        }
        return ProductAdapter.getResponse(result, errors);
    }
}
