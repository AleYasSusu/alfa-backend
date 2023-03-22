package ages.alfa.mapper;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Address;
import ages.alfa.model.entity.Teacher;
import ages.alfa.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TeacherMapper implements Function<CreateTeacherRequest, Teacher> {

    @Override
    public Teacher apply(final CreateTeacherRequest request) {

        //todo remover os atributos de line e country?

        final Address address = Address.builder()
                .city(request.getCity())
                .country(request.getCountry())
                .firstLine(request.getFirstLine())
                .secondLine(request.getSecondLine())
                .build();

        final User user = User.builder()
                .address(address)
                .gender(request.getGender())
                .name(request.getName())
                .race(request.getRace())
                .email(request.getEmail())
                .build();

        return Teacher.builder()
                .education(request.getEducation())
                .eja(request.getEja())
                .school(request.getSchool())
                .subject(request.getSubject())
                .user(user)
                .build();
    }
}
