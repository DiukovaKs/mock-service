package parcer.project.mockservice.domain.seek.job.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.domain.seek.job.JobService;
import parcer.project.mockservice.domain.seek.job.event.JobEvent;
import parcer.project.mockservice.entity.JobEntity;

@Component
public class JobCrudListener implements ApplicationListener<JobEvent> {
    @Autowired
    private JobService service;

    @Override
    public void onApplicationEvent(JobEvent event) {

        String type = event.getType();

        switch (type) {
            case JobEvent.CREATE_TYPE:
                JobEntity job = service.create();
                event.setJob(job);
                break;
            case JobEvent.UPDATE_TYPE:
                break;
            default:
                System.out.println("Received spring custom event - " + event.getJob());
        }
    }
}
