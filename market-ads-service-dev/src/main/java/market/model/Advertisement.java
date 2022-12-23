package market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import market.model.enums.ApprovedStatus;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private ZonedDateTime createDate = ZonedDateTime.now(ZoneId.of("+3"));

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @NotBlank
    private String description;

    @NotNull
    private Boolean isArchived = false;


    @NotNull
    private ApprovedStatus isApproved = ApprovedStatus.ON_CHECKING;

    @NotNull
    private Long createdBy;

    @JsonIgnore
    @ElementCollection
    @NotNull
    private Set<Long> pictures = new HashSet<>();

    @JsonIgnore
    @ElementCollection
    @NotNull
    private Set<Long> likes = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "item_id")
    @NotNull
    @ToString.Exclude
    private Item item;

    @OneToMany(mappedBy = "advertisement")
    @ToString.Exclude
    private Set<Report> reports;

    @NotNull
    private Boolean important;
    private LocalDateTime importantDateFrom;
    private LocalDateTime importantDateTo;


    //заглушка
    public Iterable<Object> getExpirationDate() {
        return null;
    }
}
