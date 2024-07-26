package parcer.project.mockservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobApiDto extends RepresentationModel<JobApiDto> implements Serializable {
    private String id;
    private String sourceId;
    private String sourceJobId;
    private String title;
    private String description;
    private String company;
    private String companyId;
    private String location;
    private String workType;
    private String postedAt;
    private LocalDateTime collectedAt;
    private String link;
    private String extra;

    @JsonCreator
    public JobApiDto(@JsonProperty("id") String id,
                     @JsonProperty("sourceId") String sourceId,
                     @JsonProperty("sourceJobId") String sourceJobId,
                     @JsonProperty("title") String title,
                     @JsonProperty("description") String description,
                     @JsonProperty("company") String company,
                     @JsonProperty("companyId") String companyId,
                     @JsonProperty("extra") String extra,
                     @JsonProperty("link") String link,
                     @JsonProperty("collectedAt") LocalDateTime collectedAt,
                     @JsonProperty("postedAt") String postedAt,
                     @JsonProperty("workType") String workType,
                     @JsonProperty("location") String location) {
        this.id = id;
        this.sourceId = sourceId;
        this.sourceJobId = sourceJobId;
        this.title = title;
        this.description = description;
        this.company = company;
        this.companyId = companyId;
        this.extra = extra;
        this.link = link;
        this.collectedAt = collectedAt;
        this.postedAt = postedAt;
        this.workType = workType;
        this.location = location;
    }
}
