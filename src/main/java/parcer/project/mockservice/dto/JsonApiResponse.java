package parcer.project.mockservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JsonApiResponse<J extends RepresentationModel<JobApiDto>, O> extends RepresentationModel<JsonApiResponse<RepresentationModel<JobApiDto>, O>> implements Serializable {
    private List<Object> data;
    private Object error;

    @JsonCreator
    public JsonApiResponse(@JsonProperty("data") List<Object> data,
                     @JsonProperty("error") Object error) {
        this.data = data;
        this.error = error;
    }
}
