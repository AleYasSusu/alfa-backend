package ages.alfa.dto;

import ages.alfa.model.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentStatsDto {

    String studentName;
    String email;
    Long studentId;
    int activitiesAnswered;
    int activitiesCorrect;
    int activitiesWrong;
}
