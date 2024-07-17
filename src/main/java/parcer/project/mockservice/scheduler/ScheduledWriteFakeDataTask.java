package parcer.project.mockservice.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.service.CrudService;
import parcer.project.mockservice.service.MockService;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class ScheduledWriteFakeDataTask {
    private static final Random RANDOM = new Random();

    @Value("${fake.generate.jobs.max}")
    private int maxJobsNumber;

    private final MockService mockService;
    private final CrudService crudService;

    @Scheduled(cron = "0 0 7 * * *") //cron = "0 0 7 * * *" - start every day at 7 AM
    public void reportCurrentTime() {
        System.out.println("Scheduled task is stated!"); //TODO add logger

        int randomValue = RANDOM.nextInt(maxJobsNumber);
        List<JobDto> dtoList = mockService.getFakeData(randomValue, 0);

        dtoList.forEach(crudService::save);

        System.out.println("Scheduled task is finished!"); //TODO add logger
    }
}
