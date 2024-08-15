package parcer.project.mockservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.core.type.TypeReference;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.repository.JobRepository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Testcontainers
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RepositoryTest {

    @Autowired
    JobRepository jobRepository;

    @BeforeAll
    @SneakyThrows
    public void setDataToMongodb() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/data/testData.json")));

        List<JobEntity> entities = objectMapper.readValue(jsonString, new TypeReference<List<JobEntity>>() {});

        entities.forEach(e -> jobRepository.save(e));
    }

    @Test
    public void findJobEntitiesByPostedAtInTest() {
        List<JobEntity> entities = jobRepository.findJobEntitiesByPostedAtIn(List.of("15.07.2024"));
        Assertions.assertEquals(1, entities.size());

        entities = jobRepository.findJobEntitiesByPostedAtIn(List.of("15.07.2024", "17.07.2024"));
        Assertions.assertEquals(2, entities.size());
    }

    @Test
    public void findJobEntitiesByPostedAtInAndSourceIdIn() {
        List<JobEntity> entities = jobRepository.findJobEntitiesByPostedAtInAndSourceIdIn(List.of("15.07.2024"), List.of("seek"));
        Assertions.assertEquals(1, entities.size());

        entities = jobRepository.findJobEntitiesByPostedAtInAndSourceIdIn(List.of("15.07.2024"), List.of("indeed"));
        Assertions.assertEquals(0, entities.size());

        entities = jobRepository.findJobEntitiesByPostedAtInAndSourceIdIn(List.of("15.07.2024", "20.07.2024"), List.of("seek"));
        Assertions.assertEquals(1, entities.size());

        entities = jobRepository.findJobEntitiesByPostedAtInAndSourceIdIn(List.of("15.07.2024", "20.07.2024"), List.of("seek", "indeed"));
        Assertions.assertEquals(2, entities.size());
    }

    @AfterAll
    public void cleanUp() {
        jobRepository.deleteAll();
    }

}
