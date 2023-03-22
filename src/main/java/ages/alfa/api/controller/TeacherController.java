package ages.alfa.api.controller;

import ages.alfa.api.TeacherApi;
import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Teacher;
import ages.alfa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/teacher")
@RequiredArgsConstructor
public class TeacherController implements TeacherApi {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody final CreateTeacherRequest request) {
        return ResponseEntity.status(CREATED).body(teacherService.createNewTeacher(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> findById(@PathVariable("id") final Long idTeacher) {
        return ResponseEntity.status(FOUND).body(teacherService.findById(idTeacher));
    }
}
