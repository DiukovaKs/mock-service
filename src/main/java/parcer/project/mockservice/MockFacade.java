package parcer.project.mockservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.domain.eventsystem.JobPublisher;
import parcer.project.mockservice.entity.JobEntity;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MockFacade {

    private final JobPublisher publisher;

    public List<JobEntity> generate(int quantity, String project)
    {
        return publisher.publishGenerateEvent(
                quantity,
                project
        );
    }
}
