package market.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "purchase_date")
    @Temporal(value = TemporalType.DATE)
    private Date purchaseDate;

    @Column(name = "item_id")
    @ElementCollection
    private Set<Long> itemId;

    public Set<Long> getItemId() {
        return itemId;
    }

    public void setItemId(Set<Long> itemId) {
        this.itemId = itemId;
    }

    public Purchase(Profile profile, Date purchaseDate) {
        this.profile = profile;
        this.purchaseDate = purchaseDate;
    }

    public Purchase() {
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
