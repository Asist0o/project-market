package market.dto;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class VisitHistory {
    @NotNull
    private LocalDateTime reportDate;
    private int showingCount;


    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public int getShowingCount() {
        return showingCount;
    }

    public void setShowingCount(int showingCount) {
        this.showingCount = showingCount;
    }

    @Override
    public String toString() {
        return "VisitHistory{" +
                "reportDate=" + reportDate +
                ", showingCount=" + showingCount +
                '}';
    }
}
