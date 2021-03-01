package com.aio.allinone.dao;

import com.aio.allinone.query.QueryBuilder;
import lombok.SneakyThrows;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MongoDAO implements ProductDAO {

    private final MongoTemplate mongoTemplate;
    private static final String productPackageName = "com.aio.allinone.product.";

    public MongoDAO(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @SneakyThrows
    public Object findAll(String target) {
        Class<?> entityClass = Class.forName(productPackageName + target);
        return mongoTemplate.findAll(entityClass);
    }

    @SneakyThrows
    public List<?> find(QueryBuilder query, String target) {
        Class<?> entityClass = Class.forName(productPackageName + target);
        Query mongoQuery = new Query(Criteria.where(query.getWhere()).is(query.getIs()));
        return mongoTemplate.find(mongoQuery, entityClass);
    }

    public Object insert(Object objectToSave, String collectionName) {
        return mongoTemplate.insert(objectToSave, collectionName);
    }

    public Object updateMulti(QueryBuilder query, QueryBuilder updateQuery, String collectionName) {
        String where = query.getWhere();
        String is = query.getIs();
        Query mongoQuery = new Query(Criteria.where(where).is(is));
        Update update = new Update();

        return mongoTemplate.updateMulti(mongoQuery, update, collectionName);
    }

    public Object remove(QueryBuilder query, String collectionName) {
        String where = query.getWhere();
        String is = query.getIs();
        Query mongoQuery = new Query(Criteria.where(where).is(is));
        return mongoTemplate.remove(mongoQuery, collectionName);
    }

    public Object updateFirst(QueryBuilder query, QueryBuilder updateQuery, String collectionName) {
        String where = query.getWhere();
        String is = query.getIs();
        Query mongoQuery = new Query(Criteria.where(where).is(is));
        Update update = new Update();
        Map<String, Object> updateData = updateQuery.getUpdate();
        updateData.keySet().forEach(key -> update.set(key, updateData.get(key)));
        return mongoTemplate.updateFirst(mongoQuery, update, collectionName);
    }
}
