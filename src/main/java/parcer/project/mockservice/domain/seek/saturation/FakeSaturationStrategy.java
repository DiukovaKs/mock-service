package parcer.project.mockservice.domain.seek.saturation;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.entity.JobEntity;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class FakeSaturationStrategy implements SaturationStrategyInterface {
    private final Faker faker = new Faker(new Locale("en-NZ"));

    @Override
    public void saturate(JobEntity job, String source) {
        Random random = new Random();
        List<String>list =  Arrays.asList("Full-time", "part-time", "contract");
        int randomIndex = random.nextInt(list.size());
        random.nextInt(list.size());
        job.setId(UUID.randomUUID());
        job.setCompanyId(faker.idNumber().toString());
        job.setSourceJobId(faker.idNumber().toString());
        job.setTitle(faker.job().title());
        job.setDescription(faker.shakespeare().hamletQuote());
        job.setCompany(faker.company().name());
        job.setLocation(faker.address().fullAddress());
        job.setPostedAt(faker.date().toString());
        job.setPostedAt(LocalDateTime.now().toString());
        job.setWorkType(list.get(randomIndex));
        job.setCollectedAt(LocalDateTime.now());
        job.setLink(faker.company().url());
        job.setExtra(faker.job().position());
        job.setSourceId(source);
    }
}
