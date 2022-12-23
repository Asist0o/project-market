package market.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document(collection="user_activity")
public class UserActivity {
    @Id
    @Field(name="account_id")
    private Long accountId;

    @NotNull
    @Field(name="last_visit_date")
    private LocalDateTime lastVisitDate;

    @NotNull
    @Field(name="visit_history")
    private Set<VisitHistory> visitHistory = new HashSet<>();


    public Long getAccountId() {
        return accountId;
    }

    public LocalDateTime getLastVisitDate() {
        return lastVisitDate;
    }

    public Set<VisitHistory> getVisitHistory() {
        return visitHistory;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setLastVisitDate(LocalDateTime lastVisit) {
        this.lastVisitDate = lastVisit;
    }

    public void setVisitHistory(Set<VisitHistory> visitHistory) {
        this.visitHistory = visitHistory;
    }

    public void addVisitHistory(VisitHistory visitHistory) {
        this.visitHistory.add(visitHistory);
    }

    @Override
    public String toString() {
        return "UserActivity{" +
                "account_id=" + accountId +
                ", lastVisitDate=" + lastVisitDate +
                ", visitHistory=" + visitHistory +
                '}';
    }
}
