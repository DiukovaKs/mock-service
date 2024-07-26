package parcer.project.mockservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.get;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class MockServiceApplicationTests {

    @Test
    public void testJobsJsonSchema() {
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

}
