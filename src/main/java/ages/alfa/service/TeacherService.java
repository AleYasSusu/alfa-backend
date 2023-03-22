package ages.alfa.service;


import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Teacher;

public interface TeacherService {

    Teacher findByUserId(final Long userId);

    Teacher findById(final Long teacherId);

    Teacher createNewTeacher(final CreateTeacherRequest request);

    boolean alreadyExistsEmail(final String email);
}
