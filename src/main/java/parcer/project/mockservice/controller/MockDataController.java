package parcer.project.mockservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parcer.project.mockservice.MockFacade;
import parcer.project.mockservice.dto.JobApiDto;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.dto.request.MockCreateRequest;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.service.CrudService;
import parcer.project.mockservice.service.MockService;

import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/mock/jobs")
@RequiredArgsConstructor
public class MockDataController {
    private final MockService mockService;
    private final CrudService crudService;
    private final MockFacade mockFacade;

    @GetMapping(path = "")
    @ResponseBody
    public List<JobApiDto> getJobs(
            @RequestParam(value = "filter[date]", required = false) List<String> date,
            @RequestParam(value = "filter[source]", required = false) List<String> source
    ) throws InvalidPropertiesFormatException {
        return crudService.getResultByFilteredFields(date, source);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public List<JobEntity> create(@Valid @RequestBody MockCreateRequest mockCreateRequest) {
        return mockFacade.generate(mockCreateRequest.getQuantity(), mockCreateRequest.getProject());
    }

    @GetMapping(path = "/fake")
    public List<JobDto> getFakeData(@RequestParam(defaultValue = "10") int jobsCount,
                                    @RequestParam(defaultValue = "7") int pastDays) {
        //TODO replace after testing!
        return mockService.getFakeData(jobsCount, pastDays);
    }
}
