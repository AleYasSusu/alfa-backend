package ages.alfa.service.impl;

import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.ClassStudent;
import ages.alfa.model.entity.Student;
import ages.alfa.repository.ClassRepository;
import ages.alfa.repository.ClassStudentRepository;
import ages.alfa.service.ClassStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClassStudentServiceImpl implements ClassStudentService {

    final private ClassStudentRepository classStudentRepository;
    final private ClassRepository classRepository;


    @Override
    public ClassStudent addStudentToClass(final Long classId, final Student student) {

        final Class aClass = classRepository.findById(classId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final ClassStudent newClassStudent = ClassStudent.builder()
                .classz(aClass)
                .student(student)
                .build();

        return classStudentRepository.save(newClassStudent);
    }
}
