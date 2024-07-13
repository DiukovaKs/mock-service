package parcer.project.mockservice.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.dto.JobDto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class MockService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final Random RANDOM = new Random();
    private static final int MAX = 4;
    private static final int MIN = 1;

    public List<JobDto> getFakeData(int jobsCount, int pastDays) {
        List<JobDto> list = new ArrayList<>(jobsCount);
        Faker faker = new Faker(new Locale("en-NZ"));

        for (int i = 0; i < jobsCount; i++) {
            JobDto jobDto = new JobDto();
            int randomValue = RANDOM.nextInt(MAX - MIN) + MIN; //random value from MIN to MAX

            jobDto.setId(Long.parseLong(String.valueOf(i)));
            jobDto.setTitle(faker.job().position());
            jobDto.setDescription(getSkills(randomValue, faker));
            jobDto.setCompany(faker.company().name());
            jobDto.setLocation(faker.address().fullAddress());
            jobDto.setPostedAt(DATE_FORMAT.format(faker.date().past(pastDays, TimeUnit.DAYS)));

            jobDto.setWorkType(getWorkType(randomValue));

            list.add(jobDto);
        }

        return list;
    }

    private String getWorkType(int randomValue) {
        if (randomValue % 2 == 0) {
            return "full-time";
        } else {
            return "part-time";
        }
    }

    private String getSkills(int randomValue, Faker faker) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < randomValue; j++) {
            sb.append(faker.job().keySkills())
                    .append(", ");
        }

        return sb.substring(0, sb.toString().length() - 2);
    }
}
