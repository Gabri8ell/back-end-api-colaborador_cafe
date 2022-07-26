package com.mypc.backEndApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CpfExistenteException extends Exception {

    public CpfExistenteException (String cpf){
        super("Já Existe Colaborador cadastrado com o CPF: " + cpf);
       
    }   
}
