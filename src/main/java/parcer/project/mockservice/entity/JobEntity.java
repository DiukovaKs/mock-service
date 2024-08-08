package parcer.project.mockservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "jobs")
@Getter
@Setter
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceJobId(String sourceJobId) {
        this.sourceJobId = sourceJobId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public void setCollectedAt(LocalDateTime collectedAt) {
        this.collectedAt = collectedAt;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}

