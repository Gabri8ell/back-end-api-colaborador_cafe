package com.mypc.backEndApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ColaboradorInexistenteException extends Exception{

    public ColaboradorInexistenteException(Integer id){
        super("Colaborador com id: " + id + "Não existe");
    }

}