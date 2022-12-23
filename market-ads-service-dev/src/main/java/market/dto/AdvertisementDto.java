package market.dto;


import market.model.Item;
import market.model.enums.ApprovedStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public record AdvertisementDto (Long id, @NotNull String description, @NotEmpty Set<Long> pictures,
                                @NotNull Item item, ApprovedStatus isApproved) {

}
