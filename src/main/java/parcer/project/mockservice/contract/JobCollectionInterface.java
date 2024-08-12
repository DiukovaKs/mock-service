package parcer.project.mockservice.contract;

import parcer.project.mockservice.entity.JobEntity;

public interface JobCollectionInterface {
    enum STAGES {
        CREATE_TYPE,
        PERSIST_TYPE,
        UPDATE_TYPE,
    }

    JobEntity getJobEntity();

    boolean isStageCreate();
    boolean isStagePersist();


    boolean isProject(String project);
}
