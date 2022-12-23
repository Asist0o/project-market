package market.dto;

import lombok.Data;
@Data
public class ItemDto {

    private Long id;
    private String brand;
    private String model;
    private Long price;
    private String itemCondition;
    private Long itemSubCategoryId;
    private Long sizeNameId;


}
