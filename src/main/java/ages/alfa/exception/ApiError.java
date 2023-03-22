package ages.alfa.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiError {

    DADOS_INVALIDOS("Dados inválidos"),
    DADO_NAO_ENCONTRADO("Dado não encontrado"),
    ERRO_LEITURA_ARQUIVO_CSV("Erro na leitura do arquivo CSV"),
    TIPO_ARQUIVO_INVALIDO("Tipo do arquivo não é formato CSV"),
    EMAIL_JA_EXISTE("O email informado já existe.");

    private final String message;

}
