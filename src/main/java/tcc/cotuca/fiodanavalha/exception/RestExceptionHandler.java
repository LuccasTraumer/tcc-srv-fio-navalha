package tcc.cotuca.fiodanavalha.exception;

import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tcc.cotuca.fiodanavalha.to.erro.ErroResponse;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FioDaNavalhaException.class)
    public ResponseEntity<ErroResponse> tratamentoErroGenerico(Exception ex, WebRequest request) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setTimestamp(LocalDateTime.now());
        erroResponse.setErro(ex.getMessage());
        erroResponse.setStatus(INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(erroResponse, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CadastroInvalidoException.class)
    public ResponseEntity<ErroResponse> tratamentoErroCadastro(Exception ex, WebRequest request) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setTimestamp(LocalDateTime.now());
        erroResponse.setErro(ex.getMessage());
        erroResponse.setStatus(NOT_ACCEPTABLE.value());

        return new ResponseEntity<>(erroResponse, NOT_ACCEPTABLE);
    }

    @ExceptionHandler(AutenticacaoException.class)
    public ResponseEntity<ErroResponse> tratamentoErroAutenticacao(Exception ex, WebRequest request) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setTimestamp(LocalDateTime.now());
        erroResponse.setErro(ex.getMessage());
        erroResponse.setStatus(UNAUTHORIZED.value());

        return new ResponseEntity<>(erroResponse, UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratamentoErroInesperado(Exception ex, WebRequest request) {
        ErroResponse erroResponse = new ErroResponse();

        erroResponse.setTimestamp(LocalDateTime.now());
        erroResponse.setErro(ex.getMessage());
        erroResponse.setStatus(INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(erroResponse, INTERNAL_SERVER_ERROR);
    }

 }
