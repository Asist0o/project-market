package market.dto.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//todo: nik: избыточная информация в классе?
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageDto {

    private Long totalElements;
    private Integer totalPages;
    private Integer pageNumber;
    private Integer pageSize;
    private Long offset;
    private Boolean hasPrevious;
}