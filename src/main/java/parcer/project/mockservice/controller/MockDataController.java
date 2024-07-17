package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.service.CrudService;
import parcer.project.mockservice.service.MockService;

import java.util.List;

@RestController
@RequestMapping("/mock/jobs")
@AllArgsConstructor
public class MockDataController {
    private final MockService mockService;
    private final CrudService crudService;

    @GetMapping(value = "/mock/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> findAllJobs() {

        return crudService.findAll();
    }

    @GetMapping(value = "/byDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> getJobsFilteredByDate(@RequestParam String date) {

        return crudService.findByPostedAt(date);
    }

    @GetMapping(value = "/byDateAndSource", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> getJobsFilteredByDateAndSource(@RequestParam String date,
                                                       @RequestParam String source) {
        return crudService.findByPostedAtAndSourceId(date, source);
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

    @GetMapping(value = "/{source}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDto> getJobsFilteredBySource(@PathVariable String source) {
        return crudService.findBySourceId(source);
    }

}
