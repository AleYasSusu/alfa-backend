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
public class ModuleDto {

    private Long classId;
    private int nivel;
    private List<LessonDto> lessonList;
    //    private List<ActivityDto> activityList;
    private String title;
    private String description;

}
