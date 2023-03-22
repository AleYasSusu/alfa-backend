package ages.alfa.service;

import ages.alfa.model.entity.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findByModuleId(Long moduleId);

    List<Activity> findByLessonId(Long lessonId);

}
