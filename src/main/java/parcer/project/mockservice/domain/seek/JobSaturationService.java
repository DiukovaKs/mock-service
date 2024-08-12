package parcer.project.mockservice.domain.seek;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.domain.seek.saturation.FakeSaturationStrategy;
import parcer.project.mockservice.entity.JobEntity;

@Component
@RequiredArgsConstructor
public class JobSaturationService implements JobSaturationInterface {
    private final FakeSaturationStrategy strategy;
    private static final String SOURCE = "SEEK";

    public JobEntity saturate(JobEntity job) {
        strategy.saturate(job, SOURCE);

        return job;
    }
}
