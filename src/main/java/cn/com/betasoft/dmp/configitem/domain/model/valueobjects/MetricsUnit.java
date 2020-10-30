package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

import lombok.Data;

@Data
public class MetricsUnit {

    private String key;

    private String name;

    private double rate;

    private boolean baseUnit;
}
