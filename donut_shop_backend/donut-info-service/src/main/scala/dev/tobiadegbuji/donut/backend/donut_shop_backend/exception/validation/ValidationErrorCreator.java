package dev.tobiadegbuji.donut.backend.donut_shop_backend.exception.validation;

import org.springframework.validation.Errors;

public class ValidationErrorCreator {

    public static ValidationError createValidationError(Errors errors) {
        ValidationError validationError =
                new ValidationError("Resource Validation failed with " + errors.getErrorCount() + " Error(S)");

        errors.getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .forEach(validationError::insertError);

        return validationError;
    }
}
