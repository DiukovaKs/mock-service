package parcer.project.mockservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import parcer.project.mockservice.dao.JobEntity;
import parcer.project.mockservice.repository.JobRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Testcontainers
@SpringBootTest
public class RepositoryTest {

    @Autowired
    JobRepository jobRepository;

    @Test
    public void testSources() {
        //TODO add test for each repository method
        JobEntity jobEntity = new JobEntity();

        jobEntity.setId(new UUID(111L, 1111L));
        jobEntity.setSourceId("11111");
        jobEntity.setCollectedAt(LocalDateTime.now());
        jobEntity.setPostedAt("15-07-2024");

        jobRepository.save(jobEntity);

        int size = jobRepository.findBy().size();
        Assertions.assertEquals(1, size);

         jobRepository.deleteAll();
    }
}
