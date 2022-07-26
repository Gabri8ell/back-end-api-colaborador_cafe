package com.mypc.backEndApi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mypc.backEndApi.dto.result.CafeManhaResult;

@Entity
public class CafeDaManha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "id_colaborador")//Muitos para um
    private Colaborador colaborador;
    
    @Column(name = "descricao")
    private String descricao;

    

    public CafeDaManha(CafeDaManha cManha) {
        this.colaborador = new Colaborador();
        this.id = cManha.getId();
        this.colaborador.setId(cManha.getColaboradorId());
        this.descricao = cManha.descricao;
    }

    public CafeDaManha(CafeManhaResult cfManhaDTO) {
        this.colaborador = new Colaborador();
        this.descricao = cfManhaDTO.getCafeDaManha();
        this.colaborador.setId(cfManhaDTO.getId_Colaborador());
    }

    public CafeDaManha() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public Integer getColaboradorId() {
        return colaborador.getId();
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getCafeDaManha() {
        return descricao;
    }

    public void setCafeDaManha(String cafeDaManha) {
        this.descricao = cafeDaManha;
    }
}
