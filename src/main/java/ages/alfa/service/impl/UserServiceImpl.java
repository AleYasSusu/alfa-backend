package ages.alfa.service.impl;

import ages.alfa.exception.ApiError;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.IUser;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.Teacher;
import ages.alfa.model.entity.User;
import ages.alfa.repository.UserRepository;
import ages.alfa.service.StudentService;
import ages.alfa.service.TeacherService;
import ages.alfa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @Override
    public IUser auth(final String email) {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiErrorException(ApiError.DADO_NAO_ENCONTRADO.getMessage(), HttpStatus.NOT_FOUND));

        final Teacher teacher = teacherService.findByUserId(user.getId());
        final Student student = studentService.findByUserId(user.getId());

        if (isNull(teacher) && isNull(student)) {
            throw new ApiErrorException(ApiError.DADO_NAO_ENCONTRADO.getMessage(), HttpStatus.NOT_FOUND);
        }

        return nonNull(teacher) ? teacher : student;
    }
}
