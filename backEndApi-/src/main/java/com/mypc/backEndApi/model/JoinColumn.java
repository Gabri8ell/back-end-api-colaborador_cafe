package com.mypc.backEndApi.model;

public class JoinColumn{
    private Integer id;
    private String cafe_da_manha;
    private Integer id_colaborador;
    private String nome;


    public JoinColumn() {
    }

    public JoinColumn(CafeDaManha cManha) {
        this.id = cManha.getId();
        this.cafe_da_manha = cManha.getCafeDaManha();
        this.id_colaborador = cManha.getColaboradorId();
        this.nome = cManha.getColaborador().getNome();
    }
    
    public Integer getId_cafe() {
        return id;
    }
   
    public void setId_cafe(Integer id_cafe) {
        this.id = id_cafe;
    }
   
    public String getNome() {
        return cafe_da_manha;
    }
   
    public void setNome(String nome) {
        this.cafe_da_manha = nome;
    }
   
    public Integer getId_colaborador() {
        return id_colaborador;
    }
   
    public void setId_colaborador(Integer id_colaborador) {
        this.id_colaborador = id_colaborador;
    }
   
    public String getNome_Colaborador() {
        return nome;
    }
   
    public void setNome_Colaborador(String nome_Colaborador) {
        this.nome = nome_Colaborador;
    }
    
    
}