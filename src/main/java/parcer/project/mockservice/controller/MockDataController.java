package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parcer.project.mockservice.domain.seek.job.publisher.JobCrudPublisher;
import parcer.project.mockservice.dto.JobApiDto;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.service.CrudService;
import parcer.project.mockservice.service.MockService;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/mock/jobs")
@AllArgsConstructor
public class MockDataController {
    private MockService mockService;
    private CrudService crudService;
    private JobCrudPublisher publisher;

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
    public List<JobEntity> postCreate() {
        List<JobEntity> collection = new ArrayList<>();

        collection.add(publisher.publishCreateEvent());

        return collection;
    }

    @GetMapping(path = "/fake")
    public List<JobDto> getFakeData(@RequestParam(defaultValue = "10") int jobsCount,
                                    @RequestParam(defaultValue = "7") int pastDays) {
        //TODO replace after testing!
        return mockService.getFakeData(jobsCount, pastDays);
    }
}
