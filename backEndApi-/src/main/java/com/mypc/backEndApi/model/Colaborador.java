package com.mypc.backEndApi.model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
import com.mypc.backEndApi.dto.result.ColabResult;

@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;
    
    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "colaborador")//Um para muitos
    private List<CafeDaManha> cafeDaManha = new ArrayList<>();


    public Colaborador(ColabResult colaboradorDTO) {
        this.nome = colaboradorDTO.getNome();
        this.cpf = colaboradorDTO.getCpf();
    } 

    public Colaborador() {
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public List<CafeDaManha> getCafeDaManha(){
        return cafeDaManha;
    }

    public void setCafeDaManha(List<CafeDaManha> cafeDaManha){
        this.cafeDaManha = cafeDaManha;
    }

}
