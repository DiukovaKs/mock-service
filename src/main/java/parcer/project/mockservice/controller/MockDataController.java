package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.service.MockService;

import java.util.List;

@RestController
@AllArgsConstructor
public class MockDataController {
    private final MockService mockService;

    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> getFakeData(@RequestParam(defaultValue = "10") int jobsCount,
                                    @RequestParam(defaultValue = "7") int pastDays) {
        return mockService.getFakeData(jobsCount, pastDays);
    }

}
