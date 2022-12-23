package market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdsDto  {

    private Long id;
    private String description;
    private ItemDto itemDto;
    private Long createdBy;
    private String pictures;
    private Boolean important;
    private LocalDateTime importantDateFrom;
    private LocalDateTime importantDateTo;

}
