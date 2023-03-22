package ages.alfa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AlternativeDto {

    private Long id;

    private String text;

    private boolean correctAnswer;

    private boolean isImg;

}
