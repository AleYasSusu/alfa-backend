package ages.alfa.api;

import ages.alfa.dto.ModuleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "ModuleApi")
public interface ModuleApi {

    @ApiOperation(value = "Busca um modulo.",
            notes = "Serviço responsável por buscar um modulo pelo seu identificador.")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<ModuleDto> findByClassId(@PathVariable final Long id);


}
