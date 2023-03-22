package ages.alfa.api;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.model.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "StudentApi")
public interface StudentApi {

    @ApiOperation(value = "Cadastra um novo estudante.",
            notes = "Serviço responsável por cadastrar um novo estudante")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<Student> create(@RequestBody final CreateStudentRequest request);
}
