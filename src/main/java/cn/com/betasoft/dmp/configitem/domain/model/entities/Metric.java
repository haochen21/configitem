package cn.com.betasoft.dmp.configitem.domain.model.entities;

public class Metric {

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

    // 可以记录来源，使用源等,json格式
    private String tags;
}
