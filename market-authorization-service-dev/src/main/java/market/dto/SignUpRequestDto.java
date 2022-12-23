package market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import market.validate.EmailExists;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    private String firstName;
    private String lastName;

    @NotBlank
    @Email
    @EmailExists
    private String email;

    @Valid
    @NotNull
    private PasswordRequestDto passwords;
}
