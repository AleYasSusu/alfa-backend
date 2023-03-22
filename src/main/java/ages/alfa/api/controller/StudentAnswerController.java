package ages.alfa.api.controller;

import ages.alfa.dto.StudentAnswerRequest;
import ages.alfa.model.entity.StudentAnswer;
import ages.alfa.service.StudentAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student-answer")
@RequiredArgsConstructor
public class StudentAnswerController {

    private final StudentAnswerService studentAnswerService;

    @PostMapping()
    public ResponseEntity<StudentAnswer> save(@RequestBody final StudentAnswerRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentAnswerService.save(request));
    }

    @GetMapping("/{studentId}/activity/{activityId}")
    public ResponseEntity<StudentAnswer> findById(@PathVariable("studentId") final Long studentAnswerId,
                                                  @PathVariable("activityId") final Long ActivityId) {

        return ResponseEntity.ok().body(studentAnswerService.findById(studentAnswerId, ActivityId));
    }
}
