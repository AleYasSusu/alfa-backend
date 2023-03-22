package ages.alfa.api.controller;

import ages.alfa.api.StudentApi;
import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Student;
import ages.alfa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController implements StudentApi {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody final CreateStudentRequest request) {
        return ResponseEntity.status(CREATED).body(studentService.createNewStudent(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long studentId) {
        return ResponseEntity.status(OK).body(studentService.findById(studentId));
    }
}