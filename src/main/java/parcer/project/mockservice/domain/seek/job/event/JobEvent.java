package parcer.project.mockservice.domain.seek.job.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import parcer.project.mockservice.entity.JobEntity;

@Getter
public class JobEvent extends ApplicationEvent {
    @Setter
    private JobEntity job;
    private final String type;

    public static final String CREATE_TYPE = "create";
    public static final String UPDATE_TYPE = "update";

    public JobEvent(Object source, JobEntity job, String type) {
        super(source);
        this.job = job;
        this.type = type;
    }

    public boolean isTypeCreate()
    {
        return type.equals(CREATE_TYPE);
    }
}