package com.aio.allinone.dao;

import com.aio.allinone.query.QueryBuilder;

import java.util.List;

public interface ProductDAO {

    List<?> find(QueryBuilder query, String product);

    Object insert(Object targetProduct, String product);

    Object updateMulti(QueryBuilder query, QueryBuilder update, String product);

    Object remove(QueryBuilder query, String product);

    Object updateFirst(QueryBuilder query, QueryBuilder update, String product);

    Object findAll(String product);
}
