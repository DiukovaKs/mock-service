package parcer.project.mockservice.domain.seek.job.saturation;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import parcer.project.mockservice.entity.JobEntity;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;

@Component
public class FakeSaturationStrategy implements SaturationStrategyInterface {
    private final Faker faker = new Faker(new Locale("en-NZ"));

    @Override
    public void saturate(JobEntity job, String source) {
        job.setId(UUID.randomUUID());
        job.setCompanyId(faker.idNumber().toString());
        job.setSourceJobId(faker.idNumber().toString());
        job.setTitle(faker.job().title());
        job.setDescription(faker.shakespeare().hamletQuote());
        job.setCompany(faker.company().name());
        job.setLocation(faker.address().fullAddress());
        job.setPostedAt(faker.date().toString());
        job.setPostedAt(LocalDateTime.now().toString());
        job.setWorkType("");
        job.setLink(faker.company().url());
        job.setExtra(faker.job().position());
        job.setSourceId(source);
    }
}
