package market.dto;

import java.time.LocalDateTime;
public class ActivityByRageDate {
    private LocalDateTime date;
    private int count;

    public ActivityByRageDate(LocalDateTime date, int count) {
        this.date = date;
        this.count = count;
    }

    public ActivityByRageDate() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
