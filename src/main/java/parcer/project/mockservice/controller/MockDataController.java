package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import parcer.project.mockservice.dao.JobEntity;
import parcer.project.mockservice.dto.ErrorApiDto;
import parcer.project.mockservice.dto.JobApiDto;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.dto.JsonApiResponse;
import parcer.project.mockservice.repository.JobRepository;
import parcer.project.mockservice.service.CrudService;
import parcer.project.mockservice.service.MockService;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mock/jobs")
@AllArgsConstructor
public class MockDataController {
    private final MockService mockService;
    private final CrudService crudService;

    @GetMapping(value = "/")
    public HttpEntity<JsonApiResponse> getJobs(
            @RequestParam(value = "filter[date]", required = false) List<String> date,
            @RequestParam(value = "filter[source]", required = false) List<String> source
    ) {
        JsonApiResponse response = new JsonApiResponse();

        try {
            List<JobApiDto> jobs = crudService.getResultByFilteredFields(date, source);
            response.setData(jobs.stream().map(e -> (Object)e).toList());
            response.setError(new ErrorApiDto());
        } catch (InvalidPropertiesFormatException e) {
            response.setData(new ArrayList<>(0));
            response.setError(new ErrorApiDto("400", e.getMessage()));
        }

        response.add(linkTo(methodOn(MockDataController.class).getJobs(date, source)).withSelfRel());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    public void checkValue() {
        JobDto dto = mockService.getFakeData(1, 1).get(0);
        //TODO remove after testing!
        crudService.save(dto);
    }

    @GetMapping(value = "/fake", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> getFakeData(@RequestParam(defaultValue = "10") int jobsCount,
                                    @RequestParam(defaultValue = "7") int pastDays) {
        //TODO replace after testing!
        return mockService.getFakeData(jobsCount, pastDays);
    }
}
