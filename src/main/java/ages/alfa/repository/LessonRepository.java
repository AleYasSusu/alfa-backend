package ages.alfa.repository;

import ages.alfa.model.entity.Lesson;
import ages.alfa.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findAllByModule(final Module module);

}
