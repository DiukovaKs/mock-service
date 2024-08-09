package parcer.project.mockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MockServiceApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(MockServiceApplication.class, args);
    }
}
