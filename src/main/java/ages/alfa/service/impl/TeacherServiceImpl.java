package ages.alfa.service.impl;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.exception.ApiError;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.mapper.TeacherMapper;
import ages.alfa.model.entity.Teacher;
import ages.alfa.repository.TeacherRepository;
import ages.alfa.repository.UserRepository;
import ages.alfa.service.TeacherService;
import ages.alfa.validator.CreateTeacherRequestValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepository;
    private final CreateTeacherRequestValidator validator;
    private final UserRepository userRepository;

    @Override
    public Teacher findByUserId(final Long userId) {
        return teacherRepository.findByUser_Id(userId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));
    }

    @Override
    public Teacher findById(final Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));
    }

    @Override
    public Teacher createNewTeacher(final CreateTeacherRequest request) {
        if (alreadyExistsEmail(request.getEmail())) {
            throw new ApiErrorException(ApiError.EMAIL_JA_EXISTE.getMessage(), HttpStatus.BAD_REQUEST);
        } else {
            validator.accept(request);
            final Teacher teacher = teacherMapper.apply(request);

            return teacherRepository.save(teacher);
        }
    }

    @Override
    public boolean alreadyExistsEmail(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
