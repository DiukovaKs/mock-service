package parcer.project.mockservice.domain.seek;

import parcer.project.mockservice.entity.JobEntity;

public interface JobSaturationInterface {
    JobEntity saturate(JobEntity job);
}
