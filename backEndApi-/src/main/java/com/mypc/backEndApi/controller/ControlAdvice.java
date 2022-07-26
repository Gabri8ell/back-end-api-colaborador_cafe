package com.mypc.backEndApi.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mypc.backEndApi.exception.ColaboradorInexistenteException;
import com.mypc.backEndApi.exception.CpfExistenteException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ControlAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return "Campo: " + ex.getBindingResult().getFieldError().getField()
                + ex.getBindingResult().getFieldError().getDefaultMessage();
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String noSuchElementException(NoSuchElementException nsException){
        return "Descrição: " + nsException.getMessage();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String nullPointerExcption(NullPointerException npException){
        return "Descrição: " + npException.getMessage() + " " + npException.getCause();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus
    @ResponseBody
    public String sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sic){
        return ""  + sic.getMessage();
    }

    @ExceptionHandler(ColaboradorInexistenteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String colaboradorInexistenteException(ColaboradorInexistenteException ciex){
        return "" + ciex.getMessage();
    }

    @ExceptionHandler(CpfExistenteException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public String cpfExistenteException(CpfExistenteException cpfEx){
        return "" + cpfEx.getMessage();
    }

}
