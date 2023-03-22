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
public class LessonDto {

    private String text;
    private String title;
    private String description;
    private List<ActivityDto> activityList;

}
