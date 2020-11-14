package cn.com.betasoft.dmp.configitem.domain.model.aggregates;

import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ConfigItem {

    private Long id;

    private ConfigType type;

    private Map<String, Object> propertyValues = new HashMap<>();

    private String tags;

    private Integer itemVersion;

    private Date createTime;

    private Date updateTime;
}
