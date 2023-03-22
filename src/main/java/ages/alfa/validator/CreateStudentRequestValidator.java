package ages.alfa.validator;

import ages.alfa.dto.CreateStudentRequest;
import ages.alfa.exception.ApiError;
import ages.alfa.exception.ApiErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@Component
public class CreateStudentRequestValidator implements Consumer<CreateStudentRequest> {

    @Override
    public void accept(CreateStudentRequest request) {

        //todo remover os atributos de line e country?

        ofNullable(request)
                .filter(req -> nonNull(request.getCity()))
                .filter(req -> nonNull(request.getEmail()))
                .filter(req -> nonNull(request.getGender()))
                .filter(req -> nonNull(request.getName()))
                .filter(req -> nonNull(request.getRace()))
                .filter(req -> nonNull(request.getAge()))
                .orElseThrow(() -> new ApiErrorException(ApiError.DADOS_INVALIDOS.getMessage(), HttpStatus.BAD_REQUEST));

    }
}
