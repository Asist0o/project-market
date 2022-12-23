package market.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AccountResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private boolean isBlocked;
}
