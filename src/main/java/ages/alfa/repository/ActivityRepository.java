package ages.alfa.repository;

import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Lesson;
import ages.alfa.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByModule(final Module module);

    List<Activity> findAllByLesson(final Lesson module);

}
