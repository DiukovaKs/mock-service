package parcer.project.mockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import parcer.project.mockservice.dbo.JobEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends MongoRepository<JobEntity, UUID> {

    List<JobEntity> findBySourceId(String sourceId);

    List<JobEntity> findByPostedAt(String postedAt);

    List<JobEntity> findByPostedAtAndSourceId(String postedAt, String sourceId);
}
