package parcer.project.mockservice.service;

import com.fasterxml.uuid.Generators;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.dto.JobDto;
import parcer.project.mockservice.dto.WorkType;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class MockService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final Random RANDOM = new Random();
    private static final int MAX = 4;
    private static final int MIN = 1;
    private static final Map<Integer, String> SOURCE_ID_MAP = new HashMap<>(4);
    public static final String TIME_ZONE = "Pacific/Auckland";

    @PostConstruct
    void init() {
        SOURCE_ID_MAP.put(1, "seek");
        SOURCE_ID_MAP.put(2, "indeed");
        SOURCE_ID_MAP.put(3, "asb");
        SOURCE_ID_MAP.put(4, "any");
    }

    public List<JobDto> getFakeData(int jobsCount, int pastDays) {
        List<JobDto> list = new ArrayList<>(jobsCount);
        Faker faker = new Faker(new Locale("en-NZ"));

        for (int i = 0; i < jobsCount; i++) {
            JobDto jobDto = new JobDto();
            int randomValue = RANDOM.nextInt(MAX - MIN) + MIN; //random value from MIN to MAX

            jobDto.setId(Generators.timeBasedEpochGenerator().generate().toString());
            jobDto.setCompanyId(faker.idNumber().toString());
            jobDto.setSourceId(getRandomSourceId());
            jobDto.setSourceJobId(faker.idNumber().toString());
            jobDto.setTitle(faker.job().title());
            jobDto.setDescription(getSkills(randomValue, faker));
            jobDto.setCompany(faker.company().name());
            jobDto.setLocation(faker.address().fullAddress());

            Date dateAndTime = pastDays == 0 ? new Date() : faker.date().past(pastDays, TimeUnit.DAYS);

            jobDto.setPostedAt(DATE_FORMAT.format(dateAndTime));
            jobDto.setCollectedAt(LocalDateTime.now(ZoneId.of(TIME_ZONE)));

            jobDto.setWorkType(getWorkType());
            jobDto.setLink(faker.company().url());
            jobDto.setExtra(faker.job().position());

            list.add(jobDto);
        }

        return list;
    }

    private String getWorkType() {
        int randomValue = RANDOM.nextInt(3);

        return WorkType.values()[randomValue].getType();
    }

    private String getSkills(int randomValue, Faker faker) {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < randomValue; j++) {
            sb.append(faker.job().keySkills())
                    .append(", ");
        }

        return sb.substring(0, sb.toString().length() - 2);
    }

    private String getRandomSourceId() {
        int randomValue = RANDOM.nextInt(3) + 1;

        return SOURCE_ID_MAP.get(randomValue);
    }
}
