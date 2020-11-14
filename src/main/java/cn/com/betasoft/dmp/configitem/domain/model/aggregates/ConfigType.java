package cn.com.betasoft.dmp.configitem.domain.model.aggregates;

import cn.com.betasoft.dmp.configitem.domain.model.entities.Metric;
import cn.com.betasoft.dmp.configitem.domain.model.entities.Property;
import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.ConfigTypeMetaData;
import cn.com.betasoft.dmp.configitem.domain.r2dbc.ConfigTypeEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConfigType {

    private UUID id;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    private String displayName;

    private String icon;

    private ConfigTypeMetaData metaData;

    private Map<String, Object> extraMetaData;

    private Map<String, Property> propertyMap = new HashMap<>();

    private Map<String, Metric> metricMap = new HashMap<>();

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private Long version;

    public static ConfigType covertFromEntity(ConfigTypeEntity configTypeEntity) {
        ConfigType configType = new ConfigType();
        configType.setId(configTypeEntity.getId());
        configType.setName(configTypeEntity.getName());
        configType.setDisplayName(configTypeEntity.getDisplayName());
        configType.setDescription(configTypeEntity.getDescription());
        configType.setIcon(configTypeEntity.getIcon());
        configType.setMetaData(configTypeEntity.getMetaData());
        configType.setExtraMetaData(configTypeEntity.getExtraMetaData());
        configType.setCreateAt(configTypeEntity.getCreateAt());
        configType.setUpdateAt(configTypeEntity.getUpdateAt());
        configType.setVersion(configTypeEntity.getVersion());
        return configType;
    }
}
