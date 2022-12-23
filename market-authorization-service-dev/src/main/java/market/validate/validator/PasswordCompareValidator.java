package market.validate.validator;

import market.dto.PasswordRequestDto;
import market.validate.PasswordCompare;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCompareValidator implements ConstraintValidator<PasswordCompare, PasswordRequestDto> {

    @Override
    public boolean isValid(PasswordRequestDto passwordDto, ConstraintValidatorContext constraintValidatorContext) {
        return passwordDto.getPassword().equals(passwordDto.getPasswordConfirm());
    }
}