package ages.alfa.service.impl;

import ages.alfa.dto.ActivityDto;
import ages.alfa.dto.AlternativeDto;
import ages.alfa.dto.LessonDto;
import ages.alfa.dto.ModuleDto;
import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Class;
import ages.alfa.model.entity.Module;
import ages.alfa.model.entity.*;
import ages.alfa.repository.*;
import ages.alfa.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;
    private final LessonRepository lessonRepository;
    private final AlternativeRepository alternativeRepository;
    private final ActivityRepository activityRepository;
    private final ClassRepository classRepository;

    public List<Module> findByClassId(final Long classId) {

        final Class classz = classRepository.findById(classId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return moduleRepository.findAllByClassz(classz);
    }

    @Override
    public Module save(final ModuleDto moduleDto) {

        final Class classz = classRepository.findById(moduleDto.getClassId())
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        final Module newModule = Module.builder()
                .classz(classz)
                .nivel(moduleDto.getNivel())
                .title(moduleDto.getTitle())
                .description(moduleDto.getDescription())
                .build();

        final Module moduleSaved = moduleRepository.save(newModule);

        for (LessonDto lessonDto : moduleDto.getLessonList()) {
            Lesson newLesson = Lesson.builder()
                    .module(moduleSaved)
                    .title(lessonDto.getTitle())
                    .description(lessonDto.getDescription())
                    .text(lessonDto.getText())
                    .build();

            newLesson.setActivities(lessonDto.getActivityList().size());
            final Lesson lessonSaved = lessonRepository.save(newLesson);

            for (ActivityDto activityDto : lessonDto.getActivityList()) {

                Activity newActivity = Activity.builder()
                        .lesson(lessonSaved)
                        .module(moduleSaved)
                        .title(activityDto.getTitle())
                        .description(activityDto.getDescription())
                        .text(activityDto.getText())
                        .urlImg(activityDto.getUrlImg())
                        .build();

                Activity activitySaved = activityRepository.save(newActivity);

                for (AlternativeDto alternativeDto : activityDto.getAlternativeList()) {
                    Alternative newAlternative = Alternative.builder()
                            .activity(activitySaved)
                            .correctAnswer(alternativeDto.isCorrectAnswer())
                            .isImg(alternativeDto.isImg())
                            .text(alternativeDto.getText())
                            .build();

                    alternativeRepository.save(newAlternative);
                }
            }
        }
        return moduleSaved;
    }
}