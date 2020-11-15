package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

public enum PropertyDataType {

    BIGINT("长整形"), BOOLEAN("布尔型"), BYTEA("字节流"), INTEGER("整形"),
    JSONB("json"), REAL("小数"), STRING("字符窜"), TIMESTAMP("时间"), UUID("uuid");

    private String description;

    PropertyDataType(String description) {
        this.description = description;
    }
}
