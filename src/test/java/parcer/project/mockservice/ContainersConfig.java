package parcer.project.mockservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

@EnableMongoRepositories
@Configuration
public class ContainersConfig {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.11")
            .withExposedPorts(27017);

    static {
        mongoDBContainer.start();
        var mappedPort = mongoDBContainer.getMappedPort(27017);
        System.setProperty("mongodb.container.port", String.valueOf(mappedPort));

        System.out.println("Test mongodb container started");
    }

}
