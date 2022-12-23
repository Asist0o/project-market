package market.service.impl;

import lombok.AllArgsConstructor;
import market.dto.AccountResponseDto;
import market.dto.SignUpRequestDto;
import market.dto.converter.Converter;
import market.dto.page.PageContentResponseDto;
import market.entity.Account;
import market.repository.AccountRepository;
import market.service.AccountService;
import market.service.RoleService;
import market.service.impl.specification.AccountSpecification;
import market.util.PageContentUtils;
import market.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final RoleService roleService;
    private final Converter<Account, AccountResponseDto> converter;
    private final PasswordEncoder passwordEncoder;
    private final PageContentUtils<Account, AccountResponseDto> pageContentUtils;

    @Override
    public Boolean existByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }

    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("Account not found by email: " + email)
        );
    }

    @Transactional
    @Override
    public AccountResponseDto saveAccount(Account account) {
        if (account.getPassword() != null) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
        }
        return converter.convertToDto(accountRepository.save(account));
    }

    @Override
    public AccountResponseDto saveAccount(SignUpRequestDto signUpRequestDto) {
        Account account = new Account();
        account.setName(signUpRequestDto.getFirstName());
        account.setLastName(signUpRequestDto.getLastName());
        account.setEmail(signUpRequestDto.getEmail());
        account.setPassword(signUpRequestDto.getPasswords().getPassword());
        account.setIsBlocked(false);
        account.setRole(roleService.getUserRole());
        return saveAccount(account);
    }

    @Override
    public AccountResponseDto findByEmail(String email) {
        return converter.convertToDto(accountRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("Account not found by email: " + email)
        ));
    }

    @Override
    public PageContentResponseDto<AccountResponseDto> findAllAccounts(int pageNumber, int pageSize, String emailSnippet) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
        Page<Account> accountPage = findAllPageable(pageable,emailSnippet);
        return pageContentUtils.getPageContentDto(accountPage, converter, pageable);
    }


    @Override
    public AccountResponseDto createAccount(String name, String lastName, String email, String password, boolean isBlocked) {
        Account account = new Account();
        account.setName(name);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setPassword(password);
        account.setRole(roleService.getUserRole());
        return saveAccount(account);
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.getById(id);
    }

    private Page<Account> findAllPageable (Pageable pageable, String emailSnippet) {
        Page<Account> accountPage;
        Specification<Account> specification = AccountSpecification.hasEmailLike(emailSnippet);
        if (StringUtils.isEmpty(emailSnippet)) {
            accountPage = accountRepository.findAll(pageable);
        } else if (emailSnippet.replace(" ", "").length() > 0) {
            accountPage = accountRepository.findAll(specification, pageable);
        } else {
            throw new RuntimeException("Incorrect email snippet: " + emailSnippet);
        }

        return accountPage;
    }

}
