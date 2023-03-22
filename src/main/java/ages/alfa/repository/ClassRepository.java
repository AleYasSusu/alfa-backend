package ages.alfa.repository;

import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {

    List<Class> findAllByTeacher(final Teacher teacher);

}
