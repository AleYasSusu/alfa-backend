package ages.alfa.api;

import ages.alfa.model.IUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "AuthenticationApi")
public interface AuthenticationApi {

    @ApiOperation(value = "Lista os dados do usuário.",
            notes = "Serviço responsável por buscar todos os dados do usuário dado o email usado no cadastro.")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso."),
            @ApiResponse(code = 400, message = "Solicitação inválida."),
            @ApiResponse(code = 404, message = "Serviço não encontrado."),
            @ApiResponse(code = 505, message = "Erro no servidor.")})
    ResponseEntity<IUser> auth(@RequestParam final String email);

}
