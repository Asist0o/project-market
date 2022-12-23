package market.service;

import market.dto.AccountResponseDto;
import market.dto.SignUpRequestDto;
import market.dto.page.PageContentResponseDto;
import market.entity.Account;

public interface AccountService {

    Boolean existByEmail(String email);

    Account findAccountByEmail(String email);

    AccountResponseDto saveAccount(Account account);

    AccountResponseDto saveAccount(SignUpRequestDto signUpRequestDto);

    AccountResponseDto findByEmail(String email);

    PageContentResponseDto<AccountResponseDto> findAllAccounts(int pageNumber, int pageSize, String emailSnippet);

    AccountResponseDto createAccount(String name, String lastName, String email, String password, boolean isBlocked);

    Account findAccountById (Long id);
}
