package parcer.project.mockservice.exception;

import java.util.List;
import java.util.Map;

public record ValidationHttpError(String message, Map<String, List<String>> errors) {
}
