package com.example.postsline.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

import java.util.Objects;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidParamsForPostListValidator implements ConstraintValidator<ValidParamsForPostList, Object[]> {

    @Override
    public boolean isValid(Object[] args, ConstraintValidatorContext context) {

        if (args.length != 3) {
            return false;
        }

        if (Objects.nonNull(args[0])) {
            if (!(args[0] instanceof Integer) || !pageSizeIsGood((Integer) args[0])) {
                return false;
            }
        }

        if (Objects.nonNull(args[2])) {
            return args[2] instanceof String && searchedByIsGood((String) args[2]);
        } else
            return true;

    }

    private boolean pageSizeIsGood(Integer pageSize) {

        return pageSize >= 1 && pageSize <= 100;

    }

    private boolean searchedByIsGood(String arg) {

        return arg.length() >= 2 && arg.length() <= 30;

    }

}
