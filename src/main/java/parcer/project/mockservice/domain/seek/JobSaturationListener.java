package parcer.project.mockservice.domain.seek;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.contract.JobCollectionInterface;
import parcer.project.mockservice.domain.eventsystem.JobEvent;

@Component
@RequiredArgsConstructor
@Order(1)
public class JobSaturationListener implements ApplicationListener<JobEvent> {
    private final JobSaturationInterface jobSaturationInterface;

    @Override
    public void onApplicationEvent(@NotNull JobEvent event) {

        if (!isSupport(event)) {
            return;
        }

        jobSaturationInterface.saturate(event.getJob());

        event.setStagePersist();
    }

    private boolean isSupport(JobCollectionInterface event) {
        return event.isProject("SEEK") && event.isStageCreate();
    }
}
