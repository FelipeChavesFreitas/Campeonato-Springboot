package com.example.ada.gestorDeTorneios.config;

import com.example.ada.gestorDeTorneios.dto.ErrorDTO;
import com.example.ada.gestorDeTorneios.exceptions.GrupoNotFoundException;
import com.example.ada.gestorDeTorneios.exceptions.JogadorNotFoundException;
import com.example.ada.gestorDeTorneios.exceptions.EquipeNotFoundException;
import com.example.ada.gestorDeTorneios.exceptions.TorneioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class HandlerException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(JogadorNotFoundException.class)
    public ErrorDTO handlerJogadorNotFound(JogadorNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EquipeNotFoundException.class)
    public ErrorDTO handlerEquipeNotFound(EquipeNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TorneioNotFoundException.class)
    public ErrorDTO handlerTorneioNotFound(TorneioNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GrupoNotFoundException.class)
    public ErrorDTO handlerGrupoNotFound(GrupoNotFoundException ex){
        return ErrorDTO.builder().message(ex.getMessage()).build();
    }

}
