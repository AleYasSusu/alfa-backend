package ages.alfa.api.controller;

import ages.alfa.model.entity.Activity;
import ages.alfa.model.entity.Lesson;
import ages.alfa.service.ActivityService;
import ages.alfa.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    private final ActivityService activityService;

    @GetMapping
    public ResponseEntity<List<Lesson>> findAllbyModuleId(@RequestParam("moduleId") final Long moduleId) {
        return ResponseEntity.ok(lessonService.findByModuleId(moduleId));
    }

    @GetMapping(path = {"/{lessonId}/activity"})
    public ResponseEntity<List<Activity>> findAllbyActivity(@PathVariable("lessonId") Long lessonId) {
        return ResponseEntity.ok(activityService.findByLessonId(lessonId));
    }
}
