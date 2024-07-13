package parcer.project.mockservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private String workType;
    private String postedAt;
}
