package ages.alfa.mapper;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Address;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class StudentMapper implements BiFunction<CreateStudentRequest, Class, Student> {

    @Override
    public Student apply(final CreateStudentRequest request, final Class xClass) {

        //todo remover os atributos de line e country?

        /** .country(request.getCountry())
         .firstLine(request.getFirstLine())
         .secondLine(request.getSecondLine())
         */

        final Address address = Address.builder()
                .city(request.getCity())
                .build();

        final User user = User.builder()
                .address(address)
                .gender(request.getGender())
                .name(request.getName())
                .race(request.getRace())
                .email(request.getEmail())
                .build();

        return Student.builder()
                .classz(xClass)
                .user(user)
                .build();
    }
}
