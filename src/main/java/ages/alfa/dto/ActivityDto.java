package ages.alfa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ActivityDto {

    private Long typeId;
    private String text;
    private String title;
    private String description;
    private String urlImg;
    private List<AlternativeDto> alternativeList;

}
