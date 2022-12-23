package market.dto;

import javax.validation.constraints.NotNull;

public record SignInVkRequestDto(

        String firstName,
        String lastName,

        @NotNull
        String email) {
}
