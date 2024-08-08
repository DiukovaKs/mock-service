package parcer.project.mockservice.domain.seek.job.publisher;


import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.domain.seek.job.event.JobEvent;

@Component
public class JobCrudPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public JobEntity publishCreateEvent() {
        JobEvent jobEvent = new JobEvent(this, null, JobEvent.CREATE_TYPE);
        applicationEventPublisher.publishEvent(jobEvent);

        return jobEvent.getJob();
    }

    @Override
    public void setApplicationEventPublisher(@NotNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}