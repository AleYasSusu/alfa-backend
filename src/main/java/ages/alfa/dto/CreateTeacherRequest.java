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
public class CreateTeacherRequest implements Serializable {

    public final static long serialVersionUID = -6435801736459637912L;

    //todo remover os atributos de line e country?

    private String firstLine;

    private String secondLine;

    private String city;

    private String country;

    private Integer age;

    private String name;

    private Gender gender;

    private Race race;

    private String subject;

    private String education;

    private String school;

    private Boolean eja;

    private String email;
}
