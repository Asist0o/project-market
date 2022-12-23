package market.dto.converter.impl;

import lombok.AllArgsConstructor;
import market.dto.AccountResponseDto;
import market.dto.SignInJwtDto;
import market.dto.converter.Converter;
import market.entity.Account;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AccountConverter implements Converter<Account, AccountResponseDto> {

    @Override
    public Account convertToModel(AccountResponseDto dto) {
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public AccountResponseDto convertToDto(Account model) {
        if (model == null) {
            return null;
        }
        AccountResponseDto target = new AccountResponseDto();
        target.setId(model.getId());
        target.setFirstName(model.getName());
        target.setLastName(model.getLastName());
        target.setEmail(model.getEmail());
        target.setRole(model.getRole().getName());
        target.setBlocked(model.getIsBlocked());
        return target;
    }
    public SignInJwtDto convertToSignInJwtDto(Account model) {
        if (model == null) {
            return null;
        }
        SignInJwtDto target = new SignInJwtDto();
        target.setId(model.getId());
        target.setRole(model.getRole().getName());
        return target;
    }
}
