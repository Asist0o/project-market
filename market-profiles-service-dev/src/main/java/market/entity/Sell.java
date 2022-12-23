package market.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sales")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "sale_date")
    @Temporal(value = TemporalType.DATE)
    private Date saleDate;

    @Column(name = "item_id")
    @ElementCollection
    private Set<Long> itemId;

    public Set<Long> getItemId() {
        return itemId;
    }

    public void setItemId(Set<Long> itemId) {
        this.itemId = itemId;
    }

    public Sell(Profile profile, Date saleDate) {
        this.profile = profile;
        this.saleDate = saleDate;
    }

    public Sell() {
    }

    public Date getPurchaseDate() {
        return saleDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.saleDate = purchaseDate;
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
