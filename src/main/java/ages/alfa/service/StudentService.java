package ages.alfa.service;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Student;

public interface StudentService {

    Student findByUserId(final Long userId);

    Student findById(final Long studentId);

    Student createNewStudent(final CreateStudentRequest request);

    boolean alreadyExistsEmail(final String email);
}
