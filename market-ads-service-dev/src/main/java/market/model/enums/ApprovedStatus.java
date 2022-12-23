package market.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ApprovedStatus {
    APPROVED("Одобрен"),
    ON_CHECKING("На проверке");

    private final String nameApprovedStatus;

    private ApprovedStatus(String nameApprovedStatus) {
        this.nameApprovedStatus = nameApprovedStatus;
    }

    @JsonValue
    public String getNameApprovedStatus() {
        return nameApprovedStatus;
    }
}
