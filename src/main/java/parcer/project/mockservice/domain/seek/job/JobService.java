package parcer.project.mockservice.domain.seek.job;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.domain.seek.job.saturation.FakeSaturationStrategy;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.repository.JobRepository;

@Component
@RequiredArgsConstructor
public class JobService {
    @Autowired
    private final JobRepository repository;
    @Autowired
    private final FakeSaturationStrategy strategy;
    private static final String SOURCE = "SEEK";

    public JobEntity create() {
        JobEntity job = JobEntity.make();

        strategy.saturate(job, SOURCE);
        repository.save(job);

        return job;
    }
}
