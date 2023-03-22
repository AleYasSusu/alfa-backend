package ages.alfa.api;

import ages.alfa.dto.CreateStudentRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;

@Api(tags = "RegisterStudentApi")
public interface ResgiterStudentApi {

    ResponseEntity registerStudent(CreateStudentRequest createStudentRequest);

}
