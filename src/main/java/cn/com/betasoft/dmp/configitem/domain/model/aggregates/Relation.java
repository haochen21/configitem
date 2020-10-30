package cn.com.betasoft.dmp.configitem.domain.model.aggregates;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.Cardinality;

public class Relation {

    private Type sourceType;

    private Type targetType;

    private String relationName;

    private Cardinality cardinality;

}
