package market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @see ProfileDto in market-profile-service
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfileDto {

    private Long accountId;
    private String email;
    private String firstName;
    private String lastName;
}

