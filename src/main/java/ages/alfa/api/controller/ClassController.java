package ages.alfa.api.controller;

import ages.alfa.api.ClassApi;
import ages.alfa.dto.CreateClassRequest;
import ages.alfa.model.entity.Class;
import ages.alfa.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/class")
@RequiredArgsConstructor
public class ClassController implements ClassApi {

    private final ClassService classService;

    @PostMapping("/teacher/{id}")
    public ResponseEntity<Class> create(@RequestBody final CreateClassRequest request,
                                        @PathVariable("id") final Long teacherId) {

        return ResponseEntity.status(HttpStatus.CREATED).body(classService.create(request, teacherId));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Class> findClassById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok().body(classService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Class>> findClassByTeacherId(@RequestParam("teacherId") final Long teacherId) {
        return ResponseEntity.ok().body(classService.findClassByTeacherId(teacherId));
    }

    @GetMapping(path = "/{id}/students")
    public ResponseEntity findAllStudentByClass(@PathVariable("id") final Long classId) {
        return ResponseEntity.ok().body(classService.getStudents(classId));
    }

}
