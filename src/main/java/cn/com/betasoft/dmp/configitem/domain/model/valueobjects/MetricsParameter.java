package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

import lombok.Data;

import java.util.List;

@Data
public class MetricsParameter {

    private String name;

    private String localName;

    private String type;

    private boolean required;

    private List values;
}
