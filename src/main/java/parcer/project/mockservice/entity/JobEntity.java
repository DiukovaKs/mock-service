package parcer.project.mockservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Document(collection = "jobs")
@Getter
public class JobEntity {
    @Id
    private UUID id;

    @Indexed
    private String sourceId;
    private String sourceJobId;
    private String title;
    private String description;
    private String company;
    private String companyId;
    private String location;
    private String workType;
    @Indexed
    private String postedAt;
    private LocalDateTime collectedAt;
    private String link;
    private String extra;

    public static JobEntity make() {
        return new JobEntity();
    }
}

