package com.example.estados.exceptions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class StatesExceptionHandler {

    @Autowired
    private MessageSource messageSource;


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StateNotFondException.class)
    public ErrorMessage stateNotFound(StateNotFondException exception) {
        return new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getLocalizedMessage(),
                HttpStatus.NOT_FOUND.getReasonPhrase());
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDto> erroDtoList(MethodArgumentNotValidException exception) {

        List<ErroDto> errosDto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(erro -> {
            String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            ErroDto erroDto = new ErroDto(erro.getField(), mensagem);
            errosDto.add(erroDto);

        });
        return errosDto;
    }
}
