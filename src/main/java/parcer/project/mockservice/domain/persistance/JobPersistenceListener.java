package parcer.project.mockservice.domain.persistance;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.contract.JobCollectionInterface;
import parcer.project.mockservice.domain.eventsystem.JobEvent;
import parcer.project.mockservice.repository.JobRepository;

@Component
@Order(100)
@RequiredArgsConstructor
public class JobPersistenceListener implements ApplicationListener<JobEvent> {
    private final JobRepository repository;

    @Override
    public void onApplicationEvent(@NotNull JobEvent event) {
        if (!isSupport(event)) {
            return;
        }

        repository.save(event.getJobEntity());
    }

    private boolean isSupport(JobCollectionInterface event) {
        return event.isStagePersist();
    }
}

