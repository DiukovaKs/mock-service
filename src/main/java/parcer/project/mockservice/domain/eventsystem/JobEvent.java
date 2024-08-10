package parcer.project.mockservice.domain.eventsystem;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import parcer.project.mockservice.contract.JobCollectionInterface;
import parcer.project.mockservice.entity.JobEntity;

@Getter
public class JobEvent extends ApplicationEvent implements JobCollectionInterface {
    private final JobEntity job;
    private STAGES stage;
    private final String project;

    public JobEvent(
            Object source,
            JobEntity job,
            String project,
            STAGES stage
    ) {
        super(source);
        this.job = job;
        this.stage = stage;
        this.project = project;
    }

    @Override
    public boolean isStageCreate() {
        return this.stage.equals(STAGES.CREATE_TYPE);
    }

    @Override
    public boolean isStagePersist() {
        return this.stage.equals(STAGES.PERSIST_TYPE);
    }

    public void setStagePersist() {
        stage = STAGES.PERSIST_TYPE;
    }

    public boolean isProject(String project) {
        return this.project.equals(project);
    }

    public static JobEvent makeCreate(Object source, JobEntity job, String project) {
        return new JobEvent(source, job, project, STAGES.CREATE_TYPE);
    }

    @Override
    public JobEntity getJobEntity() {
        return job;
    }
}