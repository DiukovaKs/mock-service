package parcer.project.mockservice.domain.eventsystem;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.entity.JobEntity;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JobPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public List<JobEntity> publishGenerateEvent(int quantity, String source) {
        List<JobEntity> jobs = new ArrayList<>(quantity);
        for (var i = 0; i < quantity; i++) {
            JobEntity job = JobEntity.make();
            JobEvent jobEvent = JobEvent.makeCreate(this, job, source);

            applicationEventPublisher.publishEvent(jobEvent);

            jobs.add(job);
        }

        return jobs;
    }

    @Override
    public void setApplicationEventPublisher(@NotNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}