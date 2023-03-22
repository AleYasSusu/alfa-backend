package ages.alfa.service;

import ages.alfa.model.entity.ClassStudent;
import ages.alfa.model.entity.Student;

public interface ClassStudentService {

    ClassStudent addStudentToClass(final Long classId, final Student student);

}
