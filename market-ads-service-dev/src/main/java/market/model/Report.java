package market.model;

import lombok.Data;
import market.model.enums.ReportStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_gen")
    @SequenceGenerator(name="article_gen", sequenceName="article_seq")
    private Long Id;

    @Column(name = "data")
    @NotNull
    private ZonedDateTime createDate = ZonedDateTime.now(ZoneId.of("+3"));

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private ReportStatus status;

    @ManyToOne
    @JoinColumn(name="advertisement_id", nullable=false)
    private Advertisement advertisement;
}
