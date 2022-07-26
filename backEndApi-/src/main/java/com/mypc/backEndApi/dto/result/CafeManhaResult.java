package com.mypc.backEndApi.dto.result;

import com.mypc.backEndApi.model.CafeDaManha;

public class CafeManhaResult {

    private String descricao;

    private Integer id_Colaborador;

    

    public CafeManhaResult(CafeDaManha cafeDaManha) {
        this.descricao = cafeDaManha.getCafeDaManha();
        this.id_Colaborador = cafeDaManha.getColaborador().getId();
    }

    public CafeManhaResult() {
    }

    public String getCafeDaManha() {
        return descricao;
    }

    public void setCafeDaManha(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_Colaborador() {
        return id_Colaborador;
    }

    public void setId_Colaborador(Integer id_Colaborador) {
        this.id_Colaborador = id_Colaborador;
    }

    
    
}
