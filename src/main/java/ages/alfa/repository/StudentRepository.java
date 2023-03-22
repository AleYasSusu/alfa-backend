package ages.alfa.repository;

import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUser_Id(final Long userId);

    List<Student> findAllByClassz(final Class classz);

}
