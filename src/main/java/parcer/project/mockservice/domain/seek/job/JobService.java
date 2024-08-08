package parcer.project.mockservice.domain.seek.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.domain.seek.job.saturation.FakeSaturationStrategy;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.repository.JobRepository;

@Component
public class JobService {
    @Autowired
    private JobRepository repository;
    @Autowired
    private FakeSaturationStrategy strategy;
    private static final String SOURCE = "SEEK";

    public JobEntity create() {
        JobEntity job = JobEntity.make();

        strategy.saturate(job, SOURCE);
        repository.save(job);

        return job;
    }
}
