package parcer.project.mockservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JsonApiResponse extends RepresentationModel<JsonApiResponse> {
    private List<Object> data;
    private Object error;

    @JsonCreator
    public JsonApiResponse(@JsonProperty("data") List<Object> data,
                     @JsonProperty("error") Object error) {
        this.data = data;
        this.error = error;
    }
}
