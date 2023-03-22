package ages.alfa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAnswerRequest {

    private Long studentId;
    private Long activityId;
    private Long alternativeId;
    private Boolean correctAnswer;

}
