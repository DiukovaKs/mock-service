package parcer.project.mockservice.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class MockCreateRequest {
    @Positive
    @Max(100)
    private int quantity;
    @NotEmpty(message = "asdas")
    private String project;
}
