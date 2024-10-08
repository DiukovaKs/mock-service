package parcer.project.mockservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobDto {
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
}
