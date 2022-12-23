package market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto{
    private  Long id;
    private Long accountId;
    private String email;
    private  String lastName;
    private String firstName;
}
