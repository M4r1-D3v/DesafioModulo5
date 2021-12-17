package br.com.zup.ContaZup.config;

import br.com.zup.ContaZup.exception.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
        List<MensagemErro> mensagemErros = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemErro erro = new MensagemErro(fieldError.getDefaultMessage());

            mensagemErros.add(erro);
        }
        return mensagemErros;
    }

    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro manipularIdNaoEncontrado(IdNaoEncontradoException idNaoEncontradoException) {
        return new MensagemErro(idNaoEncontradoException.getLocalizedMessage());
    }


}


