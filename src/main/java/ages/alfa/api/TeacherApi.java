package ages.alfa.api;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.model.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "TeacherApi")
public interface TeacherApi {

    @ApiOperation(value = "Cadastra um novo professor.",
            notes = "Serviço responsável por cadastrar um professor")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<Teacher> create(@RequestBody final CreateTeacherRequest request);
}
