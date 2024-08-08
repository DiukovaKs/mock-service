package parcer.project.mockservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import parcer.project.mockservice.dto.SourceDto;
import parcer.project.mockservice.service.MockSourceService;

import java.util.List;

@RestController
@RequestMapping("/mock/source")
@AllArgsConstructor
public class MockSourceController {
    private MockSourceService mockSourceService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<SourceDto> getSources() {
        return mockSourceService.getSources();
    }
}
