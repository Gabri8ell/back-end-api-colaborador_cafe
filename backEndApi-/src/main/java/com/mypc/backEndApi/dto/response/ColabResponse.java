package com.mypc.backEndApi.dto.response;

import com.mypc.backEndApi.model.Colaborador;

public class ColabResponse {
     private Integer id;
     private String cpf;
     private String nome;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ColabResponse() {
    }
    public ColabResponse(Colaborador colab) {
        this.id = colab.getId();
        this.cpf = colab.getCpf();
        this.nome = colab.getNome();
    }
     
}
