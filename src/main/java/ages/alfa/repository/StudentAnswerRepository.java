package ages.alfa.repository;

import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Student;
import ages.alfa.model.entity.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Long> {

    Optional<StudentAnswer> findByStudentAndActivity(final Student student, final Activity activity);

}
