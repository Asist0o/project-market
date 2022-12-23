package market.dto;

import lombok.Getter;
import lombok.Setter;
import market.validate.PasswordCompare;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordCompare
public class PasswordRequestDto {

    @NotNull
    @NotBlank
    @Length(min = 8, message = "The 'password' must be greater than or equal to 8")
    private String password;

    @NotNull
    @NotBlank
    @Length(min = 8, message = "The 'password' must be greater than or equal to 8")
    private String passwordConfirm;
}
