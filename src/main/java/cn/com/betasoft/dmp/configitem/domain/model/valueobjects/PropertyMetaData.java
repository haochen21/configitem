package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

import lombok.Data;

import java.util.List;

@Data
public class PropertyMetaData {

    // 唯一约束
    private Boolean isUnique;

    // 主键
    private Boolean isKey;

    // 索引
    private Boolean isIndex;

    private String creator;

    private List<String> categories;

}
