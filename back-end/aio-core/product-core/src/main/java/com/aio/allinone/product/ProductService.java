package com.aio.allinone.product;

import com.aio.allinone.dao.MongoDAO;
import com.aio.allinone.dao.ProductDAO;
import com.aio.allinone.product.common.StatusType;

import com.aio.allinone.query.QueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductDAO dao;
    private Object result = "NoneResult";
    private final List<String> errors;

    public ProductService(MongoDAO dao) {
        this.dao = dao;
        errors = new ArrayList<>();
    }

    /**
     * 해당 제품군에 속하는 리스트를 반환
     *
     * @param product 제품 구분 (HouseProduct, StoreProduct, VehicleProduct)
     */
    public ProductResponse getProductList(String product) {
        result = dao.findAll(product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 판매자의 제품정보 반환
     *
     * @param product  제품 구분 (HouseProduct, StoreProduct, VehicleProduct)
     * @param sellerId 판매자 ID
     */
    public ProductResponse findProductBy(String product, String sellerId) {
        QueryBuilder query = QueryBuilder.builder().where("productInfo.sellerId").is(sellerId).build();
        result = dao.find(query, product);
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
        QueryBuilder selectQuery = QueryBuilder.builder().where("_id").is(targetProduct.get("_id").toString()).build();
        QueryBuilder updateQuery = QueryBuilder.builder().update(targetProduct).build();
        result = dao.updateMulti(selectQuery, updateQuery, product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 제품을 삭제한다.
     *
     * @param product 제품 구분
     * @param id      제품 ID
     */
    public ProductResponse deleteProduct(String product, String id) {
        QueryBuilder query = QueryBuilder.builder().where("_id").is(id).build();
        result = dao.remove(query, product);
        return ProductAdapter.getResponse(result);
    }

    /**
     * 해당 제품을 마감처리한다.
     *
     * @param product 제품 구분
     * @param id      제품 ID
     */
    public ProductResponse finishProduct(String product, String id) {
        QueryBuilder selectQuery = QueryBuilder.builder().where("_id").is(id).build();

        Map<String, Object> updateData = new LinkedHashMap<>();
        updateData.put("productInfo.statusType", StatusType.IMPOSSIBLE);
        QueryBuilder updateQuery = QueryBuilder.builder().update(updateData).build();

        result = dao.updateFirst(selectQuery, updateQuery, product);
        return ProductAdapter.getResponse(result, errors);
    }
}
