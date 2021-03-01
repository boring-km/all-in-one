package com.aio.allinone.query;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class QueryBuilder {
    private final String where;
    private final String is;
    private final Map<String, Object> update;
}
