package market.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AuthTokenDto(

        @NotNull
        @Pattern(regexp = "(\\w+)\\.(\\w+)\\.(\\w+)")
        String token,

        Long expireSecond) {
}
