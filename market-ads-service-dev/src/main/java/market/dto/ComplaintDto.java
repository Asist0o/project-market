package market.dto;

import market.model.enums.ReportStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public record ComplaintDto (Long id, @NotNull ZonedDateTime createDate, @NotNull String message,
                            @NotEmpty ReportStatus status){
}
