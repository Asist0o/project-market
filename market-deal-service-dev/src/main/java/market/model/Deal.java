package market.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.model.enums.StatusDeal;
import market.model.enums.TypeDeal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deal {

    @Id
    @SequenceGenerator(name = "dealIdSeq", sequenceName = "deal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealIdSeq")
    private Long id;

    @NotNull
    private Long idProducer;

    @NotNull
    private Long idConsumer;

    @NotNull
    private Long idAdvertisement;

    @NotNull
    private Long price;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private StatusDeal statusDeal;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TypeDeal typeDeal;

}
