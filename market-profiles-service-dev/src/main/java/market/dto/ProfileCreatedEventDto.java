package market.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ProfileCreatedEventDto {
    Long accountId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String city;
}
