package market.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemCondition {
    NEW_ITEM_WITH_TAG("Новая с биркой"),
    NEW_ITEM_WITHOUT_TAG("Новая без бирки"),
    HAS_DEFECTS("Есть дефекты"),
    WORN_ONCE("Надевалась один раз"),
    WORN_SEVERAL_TIMES("Надевалась несколько раз");

    private final String nameItemCondition;

    private ItemCondition(String nameItemCondition) {
        this.nameItemCondition = nameItemCondition;
    }

    @JsonValue
    public String getNameItemCondition() {
        return nameItemCondition;
    }
}
