package com.aio.allinone.dao;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import java.util.List;

/* TODO
    DAO 클래스를 통해 wrapper를 구현하려고 했으나 아직 인수에 해당 DB에 대한 상세 내용을 알도록 요구하고 있다. (캡슐화 위반)
    인터페이스를 통해 ProductDAO를 사용하는 다른 클래스가 MongoTemplate의 세부내용에 대해 모르도록 변경이 필요하다.
 */
@Service
public class ProductDAO {

    private final MongoTemplate mongoTemplate;

    public ProductDAO(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    public <T> List<T> find(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    public <T> T insert(T objectToSave, String collectionName) {
        return mongoTemplate.insert(objectToSave, collectionName);
    }

    public Object updateMulti(Query query, UpdateDefinition update, String collectionName) {
        return mongoTemplate.updateMulti(query, update, collectionName);
    }

    public Object remove(Query query, String collectionName) {
        return mongoTemplate.remove(query, collectionName);
    }

    public Object updateFirst(Query query, UpdateDefinition update, String collectionName) {
        return mongoTemplate.updateFirst(query, update, collectionName);
    }
}
