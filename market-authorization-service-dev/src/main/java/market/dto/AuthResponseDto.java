package market.dto;

public record AuthResponseDto(AccountResponseDto accountResponseDto, AuthTokenDto token) {
}
