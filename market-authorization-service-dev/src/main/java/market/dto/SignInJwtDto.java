package market.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInJwtDto {
    @NotBlank
    private Long id;
    private String role;
}
