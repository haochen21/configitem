package cn.com.betasoft.dmp.configitem.domain.model.valueobjects;

public enum Cardinality {

    ONETOONE("1:1"), ONETOMANY("1:N"),
    MANYTOONE("N:1"), MANYTOMANY("N:N");

    private String description;

    Cardinality(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Cardinality getByDescription(String description) {
        switch (description) {
            case "1:N":
                return ONETOMANY;
            case "N:1":
                return MANYTOONE;
            case "N:N":
                return MANYTOMANY;
            default:
                return ONETOONE;
        }
    }
}
