package parcer.project.mockservice.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

@RestController
@AllArgsConstructor
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    private Environment env;

    @GetMapping("/error")
    public ResponseEntity<HashMap<String, String>> handleError(HttpServletRequest req, Exception ex) {
            Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        HashMap<String, String> body = new HashMap<>();

        body.put("message", "Internal Error");
        body.put("statusCode", "500");

        if (Objects.equals(this.env.getProperty("debug"), "true")) {
            body.put("message", ex.getMessage());
            body.put("stacktrace", Arrays.toString(ex.getStackTrace()));
        }

        if (status != null) {
            try {
                HttpStatus httpStatus = HttpStatus.valueOf(Integer.parseInt(status.toString()));
                body.put("message", httpStatus.getReasonPhrase());
                body.put("statusCode", status.toString());

                return new ResponseEntity<>(body, httpStatus);
            } catch (IllegalArgumentException ignored) {}
        }

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
