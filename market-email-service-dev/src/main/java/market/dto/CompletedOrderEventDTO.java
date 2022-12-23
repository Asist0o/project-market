package market.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompletedOrderEventDTO {
    private Long accountId;
    private String firstName;
    private String lastName;
    private String email;
    private Long orderNumber;
    private String orderDate;
    private String brand;
    private String model;
    private String itemCondition;
    private String size;
    private Long price;
    private Long deliveryPrice;
    private Long discount;
    private Long orderTotal;

}
