package ages.alfa.dto;

import ages.alfa.model.enumeration.Gender;
import ages.alfa.model.enumeration.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest implements Serializable {

    public final static long serialVersionUID = 3116724084955648544L;

    private String firstLine;
    private String secondLine;
    private String country;
    private String city;
    private String name;
    private Gender gender;
    private Integer age;
    private Race race;
    private String email;
    private Long classId;
}
