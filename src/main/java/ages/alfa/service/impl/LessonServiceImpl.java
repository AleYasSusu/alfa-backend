package ages.alfa.service.impl;

import ages.alfa.exception.ApiErrorException;
import ages.alfa.model.entity.Lesson;
import ages.alfa.model.entity.Module;
import ages.alfa.repository.LessonRepository;
import ages.alfa.repository.ModuleRepository;
import ages.alfa.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static ages.alfa.exception.ApiError.DADO_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;

    @Override
    public List<Lesson> findByModuleId(final Long moduleId) {

        final Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new ApiErrorException(DADO_NAO_ENCONTRADO.getMessage(), NOT_FOUND));

        return lessonRepository.findAllByModule(module);
    }
}
