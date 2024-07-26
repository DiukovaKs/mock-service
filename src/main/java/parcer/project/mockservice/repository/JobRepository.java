package parcer.project.mockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import parcer.project.mockservice.dao.JobEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends MongoRepository<JobEntity, UUID> {

    List<JobEntity> findJobEntitiesByPostedAtIn(List<String> collectedAt);

    List<JobEntity> findJobEntitiesByPostedAtInAndSourceIdIn(List<String> collectedAt, List<String> sources);
}
