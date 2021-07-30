package be.intecbrussel.testy.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;


public class PhoneNumberValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }


    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        final String locale = phoneNumber.split(",")[0];
        final String value = phoneNumber.split(",")[1];
        if (Objects.isNull(locale) || Objects.isNull(value) || locale.length() > 3 || value.length() > 12) {
            return false;
        }

        try {
            final var phoneNumberUtil = PhoneNumberUtil.getInstance();
            return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(value, locale));
        } catch (NumberParseException e) {
            return false;
        }
    }
}