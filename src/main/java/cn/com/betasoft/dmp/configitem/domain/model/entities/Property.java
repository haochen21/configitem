package cn.com.betasoft.dmp.configitem.domain.model.entities;

import io.r2dbc.postgresql.codec.Json;

public class Property {

    private Long id;

    // 配置项类型
    private String ciTypeName;

    // 属性名称
    private String name;

    // 显示名称
    private String displayName;

    // 属性说明
    private String description;

    // 数据类型
    private String dataType;

    // 数据长度
    private Integer dataLength;

    // 默认值
    private String defaultValue;

    // 唯一约束
    private Boolean isUnique;

    // 主键
    private Boolean isKey;

    // 索引
    private Boolean isIndex;

    // 可以记录来源，使用源等,json格式
    private String tags;
}
