package ages.alfa.validator;

import ages.alfa.dto.CreateTeacherRequest;
import ages.alfa.exception.ApiError;
import ages.alfa.exception.ApiErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@Component
public class CreateTeacherRequestValidator implements Consumer<CreateTeacherRequest> {

    @Override
    public void accept(final CreateTeacherRequest request) {

        ofNullable(request)
                .filter(req -> nonNull(request.getCity()))
                .filter(req -> nonNull(request.getAge()))
                .filter(req -> nonNull(request.getEmail()))
                .filter(req -> nonNull(request.getGender()))
                .filter(req -> nonNull(request.getName()))
                .filter(req -> nonNull(request.getRace()))
                .filter(req -> nonNull(request.getSchool()))
                .filter(req -> nonNull(request.getSubject()))
                .filter(req -> nonNull(request.getEducation()))
                .filter(req -> nonNull(request.getEja()))
                .orElseThrow(() -> new ApiErrorException(ApiError.DADOS_INVALIDOS.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
