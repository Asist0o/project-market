package market.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GenderType {

    MALE("Мужской"),
    FEMALE("Женский");

    private final String nameGenderType;

    private GenderType(String nameGenderType){
        this.nameGenderType = nameGenderType;
    }

    @JsonValue
    public String getNameGenderType() {
        return nameGenderType;
    }
}
