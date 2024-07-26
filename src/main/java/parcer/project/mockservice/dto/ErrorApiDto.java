package parcer.project.mockservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ErrorApiDto extends RepresentationModel<ErrorApiDto> implements Serializable {
    private String code;
    private String message;

    @JsonCreator
    public ErrorApiDto(@JsonProperty("code") String code,
                           @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }
}
