package parcer.project.mockservice.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MockCreateRequest {
    @Positive
    @Max(100)
    @Min(1)
    private final int quantity;
    @NotEmpty(message = "Project title should be set")
    private final String project;
}
