package market.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemCategoryName {
    SHOES("Обувь"),
    TOP("Верх"),
    OUTERWEAR("Верхняя одежда"),
    BOTTOM("Низ"),
    ACCESSORIES("Аксессуары");

    private final String ruName;

    private ItemCategoryName(String ruName) {
        this.ruName = ruName;
    }

    @JsonValue
    public String getRuName() {
        return ruName;
    }
}
