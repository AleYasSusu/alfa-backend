package ages.alfa.service.impl;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.mapper.StudentMapper;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;
import ages.alfa.repository.ClassRepository;
import ages.alfa.repository.StudentRepository;
import ages.alfa.repository.UserRepository;
import ages.alfa.service.ClassStudentService;
import ages.alfa.service.StudentService;
import ages.alfa.validator.CreateStudentRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static ages.alfa.exception.ApiError.EMAIL_JA_EXISTE;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final UserRepository userRepository;
    private final CreateStudentRequestValidator validator;
    private final ClassStudentService classStudentService;

    @Override
    public Student findByUserId(final Long userId) {
        return studentRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));
    }

    @Override
    public Student findById(final Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));
    }

    @Override
    public Student createNewStudent(final CreateStudentRequest request) {
        if (alreadyExistsEmail(request.getEmail())) {
            throw new ApiErrorException(EMAIL_JA_EXISTE.getMessage(), BAD_REQUEST);
        }

        final Class xClass = classRepository.findById(request.getClassId()).orElse(null);

        validator.accept(request);

        final Student student = studentRepository.save(studentMapper.apply(request, xClass));

        if (nonNull(xClass)) {
            classStudentService.addStudentToClass(request.getClassId(), student);
        }

        return student;
    }

    @Override
    public boolean alreadyExistsEmail(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
