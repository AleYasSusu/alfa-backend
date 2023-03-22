package ages.alfa.service;

import ages.alfa.dto.CreateClassRequest;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;

import java.util.List;

public interface ClassService {

    Class create(final CreateClassRequest request, final Long teacherId);

    Class findById(final Long id);

    List<Class> findClassByTeacherId(final Long teacherId);

    List<Student> getStudents(final Long classId);

}
