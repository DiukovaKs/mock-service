package parcer.project.mockservice.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import parcer.project.mockservice.dto.request.MockCreateRequest;

public class MockDataValidator implements Validator {

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return MockCreateRequest.class.equals(clazz);
    }
}
