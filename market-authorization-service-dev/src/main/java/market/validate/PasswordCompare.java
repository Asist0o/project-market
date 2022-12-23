package market.validate;

import market.validate.validator.PasswordCompareValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCompareValidator.class)
public @interface PasswordCompare {

    String message() default "'Password' and 'PasswordConfirm' must be identical";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}