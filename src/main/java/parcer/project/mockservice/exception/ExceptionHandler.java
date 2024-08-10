package parcer.project.mockservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationHttpError> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> new ErrorPair(e.getField(), e.getDefaultMessage()))
                .collect(
                        Collectors.groupingBy(
                                ErrorPair::key,
                                Collectors.mapping(
                                        ErrorPair::value,
                                        Collectors.toList()
                                )
                        )
                );

        ValidationHttpError error = new ValidationHttpError("validation error", errors);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

record ErrorPair(String key, String value) {
}