package com.aio.allinone.product;

import com.aio.allinone.dao.ProductDAO;
import com.aio.allinone.product.common.StatusType;
import lombok.SneakyThrows;

// TODO ProductService 에서 세부 DB에 대한 사용방법을 모르도록 하자
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ProductService {

    private final ProductDAO dao;
    private static final String productPackageName = "com.aio.allinone.product.";
    private Object result = "NoneResult";
    private final List<String> errors;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
        errors = new ArrayList<>();
    }

    /**
     * 해당 제품군에 속하는 리스트를 반환
     *
     * @param product 제품 구분 (HouseProduct, StoreProduct, VehicleProduct)
     */
    @SneakyThrows
    public ProductResponse getProductList(String product) {
        Class<?> productClass = Class.forName(productPackageName + product);
        result = dao.findAll(productClass);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 판매자의 제품정보 반환
     *
     * @param product 제품 구분 (HouseProduct, StoreProduct, VehicleProduct)
     * @param sellerId 판매자 ID
     */
    @SneakyThrows
    public ProductResponse findProductBy(String product, String sellerId) {
        Query query = new Query(Criteria.where("productInfo.sellerId").is(sellerId));
        result = dao.find(query, Class.forName(productPackageName + product));
        return ProductAdapter.getResponse(result);
    }

    /**
     * 제품 정보를 등록한다.
     *
     * @param targetProduct 등록할 제품 정보
     */
    public ProductResponse registerProduct(LinkedHashMap<String, Object> targetProduct) {
        String product = targetProduct.get("type").toString();
        result = dao.insert(targetProduct, product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 제품 정보를 수정한다.
     *
     * @param targetProduct 수정할 제품 정보
     */
    public ProductResponse updateProduct(LinkedHashMap<String, Object> targetProduct) {
        String product = targetProduct.get("type").toString();
        Query query = new Query(Criteria.where("_id").is(targetProduct.get("_id").toString()));
        Update update = new Update();
        targetProduct.keySet().forEach(key -> update.set(key, targetProduct.get(key)));
        result = dao.updateMulti(query, update, product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 제품을 삭제한다.
     *
     * @param product 제품 구분
     * @param id 제품 ID
     */
    public ProductResponse deleteProduct(String product, String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        result = dao.remove(query, product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 제품을 마감처리한다.
     *
     * @param product 제품 구분
     * @param id 제품 ID
     */
    public ProductResponse finishProduct(String product, String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.set("productInfo.statusType", StatusType.IMPOSSIBLE);
        result = dao.updateFirst(query, update, product);
        return ProductAdapter.getResponse(result, errors);
    }
}
