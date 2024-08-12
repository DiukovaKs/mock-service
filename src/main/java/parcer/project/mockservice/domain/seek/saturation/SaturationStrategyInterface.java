package parcer.project.mockservice.domain.seek.saturation;

import parcer.project.mockservice.entity.JobEntity;

public interface SaturationStrategyInterface {
    void saturate(JobEntity job, String source);
}
