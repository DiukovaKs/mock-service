package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcer.project.mockservice.dto.ErrorApiDto;
import parcer.project.mockservice.dto.JsonApiResponse;
import parcer.project.mockservice.dto.SourceDto;
import parcer.project.mockservice.service.MockSourceService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mock/source")
@AllArgsConstructor
public class MockSourceController {
    private final MockSourceService mockSourceService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<JsonApiResponse> getSources() {

        List<SourceDto> jobs = mockSourceService.getSources();
        JsonApiResponse response = new JsonApiResponse();

        response.setData(jobs.stream().map(e -> (Object)e).toList());
        response.add(linkTo(methodOn(MockSourceController.class).getSources()).withSelfRel());
        response.setError(new ErrorApiDto());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
