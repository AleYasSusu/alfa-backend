package ages.alfa.service.impl;

import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Lesson;
import ages.alfa.model.entity.Module;
import ages.alfa.repository.ActivityRepository;
import ages.alfa.repository.LessonRepository;
import ages.alfa.repository.ModuleRepository;
import ages.alfa.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;
    private final ActivityRepository activityRepository;

    public List<Activity> findByModuleId(final Long moduleId) {

        final Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return activityRepository.findAllByModule(module);
    }

    public List<Activity> findByLessonId(final Long lessonId) {

        final Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return activityRepository.findAllByLesson(lesson);
    }

}
