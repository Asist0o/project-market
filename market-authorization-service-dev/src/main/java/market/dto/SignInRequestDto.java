package market.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public record SignInRequestDto(

        @Email
        String email,

        @Length(min = 8, message = "The 'password' must be greater than or equal to 8")
        String password) {
}
