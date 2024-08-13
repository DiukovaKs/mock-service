package parcer.project.mockservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.junit.jupiter.Testcontainers;
import parcer.project.mockservice.entity.JobEntity;
import parcer.project.mockservice.repository.JobRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Testcontainers
public class ControllerTest {
    @LocalServerPort
    private Integer port;

    @Autowired
    JobRepository jobRepository;

    @BeforeEach
    void setUp() {
        jobRepository.deleteAll();
        RestAssured.baseURI = "http://localhost:" + port;
    }

        @Test
    void testJobsJsonSchema() {
        setDataToRepository();

        get("/mock/jobs?filter[date]=17-07-2024,20-07-2024&filter[source]=indeed").then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("jsonJobsRespondSchema.json"));
    }

    @Test
    public void testSourcesJsonSchema() {
        get("/mock/source").then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("jsonSourcesRespondSchema.json"));
    }

    private void setDataToRepository() {
        JobEntity jobEntity = new JobEntity();

        jobEntity.setId(new UUID(111L, 1111L));
        jobEntity.setSourceId("11111");
        jobEntity.setCollectedAt(LocalDateTime.now());
        jobEntity.setPostedAt("15-07-2024");

        jobRepository.save(jobEntity);
    }
}