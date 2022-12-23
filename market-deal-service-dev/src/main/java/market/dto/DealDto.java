package market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.model.enums.StatusDeal;
import market.model.enums.TypeDeal;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DealDto {
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
    private StatusDeal statusDeal;

    @NotNull
    private TypeDeal typeDeal;
}
