package cn.com.betasoft.dmp.configitem.domain.model.aggregates;

import cn.com.betasoft.dmp.configitem.domain.model.entities.Metric;
import cn.com.betasoft.dmp.configitem.domain.model.entities.Property;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Type {

    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    private String displayName;

    private String icon;

    private Map<String, Property> propertyMap = new HashMap<>();

    private Map<String, Metric> metricMap = new HashMap<>();

    private Date createTime;

    private Date updateTime;
}
