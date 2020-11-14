package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

import lombok.Data;

import java.util.List;

@Data
public class ConfigTypeMetaData {

    private String dataSource;

    private List<String> users;

    private List<String> targets;

}
