package ages.alfa.dto;

import ages.alfa.model.enumeration.Gender;
import ages.alfa.model.enumeration.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterStudentRequest {
    private Long classId;
    private String city;
    //    private String country;
    private String email;
    //    private String firstLine;
    private Integer age;
    private Gender gender;
    private String name;
    private Race race;
//    private String secondLine;
}
