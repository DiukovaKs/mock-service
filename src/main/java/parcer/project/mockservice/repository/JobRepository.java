package parcer.project.mockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import parcer.project.mockservice.entity.JobEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends MongoRepository<JobEntity, UUID> {

    List<JobEntity> findJobEntitiesByPostedAtIn(List<String> postedAt);

    List<JobEntity> findJobEntitiesByPostedAtInAndSourceIdIn(List<String> postedAt, List<String> sources);

    List<JobEntity> findBy();
}
