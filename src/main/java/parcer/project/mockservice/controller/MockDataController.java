package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parcer.project.mockservice.service.MockService;

@RestController
@AllArgsConstructor
public class MockDataController {
    private final MockService mockService;

    @GetMapping(value = "/getSeekData", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSeekData() {
        return mockService.getSeekData();
    }

    @GetMapping(value = "/getIndeedData", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getIndeedData() {
        return mockService.getIndeedData();
    }
}
