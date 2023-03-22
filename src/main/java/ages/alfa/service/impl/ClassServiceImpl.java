package ages.alfa.service.impl;

import ages.alfa.dto.ClassInvitationDto;
import ages.alfa.dto.CreateClassRequest;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.Teacher;
import ages.alfa.repository.ClassRepository;
import ages.alfa.repository.StudentRepository;
import ages.alfa.repository.TeacherRepository;
import ages.alfa.service.ClassService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Override
    public Class findById(final Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));
    }

    @Override
    public List<Class> findClassByTeacherId(final Long teacherId) {

        final Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return classRepository.findAllByTeacher(teacher);
    }

    @Override
    public Class create(final CreateClassRequest request, final Long teacherId) {

        final Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        Class newClass = Class.builder()
                .teacher(teacher)
                .name(request.getName())
                .build();

        newClass = classRepository.save(newClass);

        final ClassInvitationDto classInvitationDto = ClassInvitationDto.builder()
                .classId(newClass.getId())
                .className(newClass.getName())
                .teacherId(teacherId)
                .teacherName(teacher.getUser().getName())
                .build();

        final String base64 = getBase64(classInvitationDto);
        newClass.setHash(base64);
        newClass.setUrlInvite(generateUrlInvite(newClass));

        return classRepository.save(newClass);
    }

    private String generateUrlInvite(final Class aClass) {
        String urlInvite = "/alfa/invite/" + aClass.getHash();
        System.out.println("Url invite: " + urlInvite);
        return urlInvite;
    }

    private String getBase64(final ClassInvitationDto classInvitationDto) {
        try {
            String originalInput = new ObjectMapper().writeValueAsString(classInvitationDto);
            String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
            return encodedString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getStudents(final Long classId) {

        final Class xClass = classRepository.findById(classId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return studentRepository.findAllByClassz(xClass);
    }
}
