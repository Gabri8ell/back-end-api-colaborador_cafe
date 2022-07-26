package com.mypc.backEndApi.service;

import java.util.List;
import java.util.Optional;

import com.mypc.backEndApi.model.CafeDaManha;

public interface CafeDaManhaService {
    
    Iterable<CafeDaManha> buscarTodos();

    String inserir(CafeDaManha cfManha);

    String atualizar(CafeDaManha cfManha, Integer id);

    String deletar(Integer id);

    List<CafeDaManha> buscarPorNome(String nome);

    Optional<CafeDaManha> buscarPorId(Integer id);

    Iterable<CafeDaManha> cafePorIdColabo(Integer id);

    Iterable<CafeDaManha> cafePorNomeColaborador(String nome);

}
