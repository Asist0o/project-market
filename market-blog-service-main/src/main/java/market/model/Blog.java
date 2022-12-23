package market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "description")
    private String description;

    @Column(name = "text")
    private String text;

    @Column(name = "imageId")
    private Long imageId;

    public Blog(Long id, LocalDateTime createDate, Long accountId, String description, String text, Long imageId) {
        this.id = id;
        this.createDate = createDate;
        this.accountId = accountId;
        this.description = description;
        this.text = text;
        this.imageId = imageId;
    }

    public Blog() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImageId(Long image) {
        this.imageId = image;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getText() {
        return text;
    }

    public Long getImageId() {
        return imageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
