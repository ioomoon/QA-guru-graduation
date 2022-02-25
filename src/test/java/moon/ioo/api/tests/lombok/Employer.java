package moon.ioo.api.tests.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employer {
    private String name;

    private Integer id;

    private Integer open_vacancies;
}
