package cn.com.betasoft.dmp.configitem.domain.model.entities;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.PropertyMetaData;
import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.PropertyStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Property {

    private UUID id;

    // 属性名称
    private String name;

    // 显示名称
    private String displayName;

    // 属性说明
    private String description;

    private UUID configTypeId;

    // 配置项类型
    private String configTypeName;

    private PropertyStatus status;

    // 数据类型
    private String dataType;

    // 数据长度
    private Integer dataLength;

    // 默认值
    private String defaultValue;

    // 可以记录来源，使用源等,json格式
    private PropertyMetaData metaData;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

}
