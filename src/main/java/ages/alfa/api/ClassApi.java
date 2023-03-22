package ages.alfa.api;

import ages.alfa.dto.CreateClassRequest;
import ages.alfa.model.entity.Class;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "ClassApi")
public interface ClassApi {

    @ApiOperation(value = "Cadastra um nova turma.",
            notes = "Serviço responsável por cadastrar uma nova turma.")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<Class> create(@RequestBody final CreateClassRequest request,
                                 @PathVariable final Long teacherId);

    @ApiOperation(value = "Busca uma turma.",
            notes = "Serviço responsável por buscar uma turma específica dado o seu identificador.")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<Class> findClassById(@PathVariable final Long id);
}
