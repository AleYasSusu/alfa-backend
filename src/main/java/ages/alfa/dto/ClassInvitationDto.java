package ages.alfa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassInvitationDto implements Serializable {

    private static final long serialVersionUID = 1262819622007461236L;

    private Long classId;
    private Long teacherId;
    private String className;
    private String teacherName;

}
