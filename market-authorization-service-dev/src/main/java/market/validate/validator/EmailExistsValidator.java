package market.validate.validator;

import lombok.AllArgsConstructor;
import market.repository.AccountRepository;
import market.validate.EmailExists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {

    private final AccountRepository accountRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !accountRepository.existsByEmail(email);
    }
}
