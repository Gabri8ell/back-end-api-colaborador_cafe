package com.mypc.backEndApi.service;

import java.text.ParseException;
import java.util.List;

import com.mypc.backEndApi.dto.result.ColabResult;
import com.mypc.backEndApi.model.Colaborador;

public interface ColaboradorService {

    Iterable<Colaborador> buscarTodos();

    String inserir(ColabResult colaboradorDTO) throws ParseException;

    String atualizar(ColabResult colaboradorDTO, Integer id) throws ParseException;

    String deletar(Integer id);

    List<Colaborador> buscarPorNome(String nome);

    Colaborador buscarPorId(Integer id);
}
