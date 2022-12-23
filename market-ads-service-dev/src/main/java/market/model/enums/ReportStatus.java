package market.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReportStatus {
    ON_CHECKING("На проверке");

    private final String statusName;

//    ComplaintStatus(String statusName) {
//        this.statusName = statusName;
//    }

    public String getStatusName() {
        return statusName;
    }
}
