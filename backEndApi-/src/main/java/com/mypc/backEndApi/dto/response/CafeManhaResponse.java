package com.mypc.backEndApi.dto.response;

import com.mypc.backEndApi.model.CafeDaManha;

public class CafeManhaResponse {

    private Integer id;

    private String descricao;

    private Integer id_colaborador;


    public CafeManhaResponse(CafeDaManha cfManha) {
        this.id = cfManha.getId();
        this.descricao = cfManha.getCafeDaManha();
        this.id_colaborador = cfManha.getColaboradorId();
    }

    

    public CafeManhaResponse(CafeManhaResponse cfResponse) {
        this.id = cfResponse.getId();
        this.descricao = cfResponse.getCafeDaManha();
        this.id_colaborador = cfResponse.getId_colaborador();
    }



    public CafeManhaResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCafeDaManha() {
        return descricao;
    }

    public void setCafeDaManha(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(Integer id_colaborador) {
        this.id_colaborador = id_colaborador;
    }
    
}
