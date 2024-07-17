package parcer.project.mockservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import parcer.project.mockservice.dto.SourceDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockSourceService {

    private static final List<SourceDto> SOURCES = new ArrayList<>(4);

    //TODO move data to DB

    @PostConstruct
    void init() {
        SOURCES.add(new SourceDto("1", "Seek"));
        SOURCES.add(new SourceDto("2", "Indeed"));
        SOURCES.add(new SourceDto("3", "Asb"));
        SOURCES.add(new SourceDto("4", "Any"));
    }

    public List<SourceDto> getSources() {
        return SOURCES;
    }
}
