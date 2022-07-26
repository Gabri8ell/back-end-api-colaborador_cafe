package com.mypc.backEndApi.dto.result;
import org.hibernate.validator.constraints.br.CPF;

import com.mypc.backEndApi.model.Colaborador;

public class ColabResult {

    private String nome;

    @CPF
    private String cpf;


    public ColabResult(Colaborador colaborador) {
        this.nome = colaborador.getNome();
        this.cpf = colaborador.getCpf();
    }


    public ColabResult() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
