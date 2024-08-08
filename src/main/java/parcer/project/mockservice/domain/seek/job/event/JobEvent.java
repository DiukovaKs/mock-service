package parcer.project.mockservice.domain.seek.job.event;

import org.springframework.context.ApplicationEvent;
import parcer.project.mockservice.entity.JobEntity;

public class JobEvent extends ApplicationEvent {
    private JobEntity job;
    private final String type;

    public static final String CREATE_TYPE = "create";
    public static final String UPDATE_TYPE = "update";

    public JobEvent(Object source, JobEntity job, String type) {
        super(source);
        this.job = job;
        this.type = type;
    }

    public JobEntity getJob() {
        return job;
    }

    public String getType() {
        return type;
    }

    public void setJob(JobEntity job) {
        this.job = job;
    }

    public boolean isTypeCreate()
    {
        return type.equals(CREATE_TYPE);
    }
}