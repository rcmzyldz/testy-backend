package be.intecbrussel.testy.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;

public class UserRoleValidator implements ConstraintValidator<ValidRole, String> {

    @Override
    public void initialize(ValidRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(String roles, ConstraintValidatorContext context) {
        final var roleSet = new HashSet<>(Arrays.asList(roles.split(",")));

        if (roleSet.isEmpty()) {
            return false;
        }

        return roles.contains("ROLE_STUDENT") ||
                roles.contains("ROLE_TEACHER") ||
                roles.contains("ROLE_MANAGER") ||
                roles.contains("ROLE_TEAM_LEADER") ||
                roles.contains("ROLE_SYSTEM_ADMIN") ||
                roles.contains("ROLE_ADMIN") ||
                roles.contains("ROLE_ANONYMOUS");
    }
}