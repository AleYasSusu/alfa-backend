package ages.alfa.service;

import ages.alfa.model.entity.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> findByModuleId(Long moduleId);

}
