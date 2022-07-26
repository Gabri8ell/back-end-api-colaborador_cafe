package com.mypc.backEndApi.repository;

import com.mypc.backEndApi.model.CafeDaManha;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CafeDaManhaRepository extends JpaRepository<CafeDaManha, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha")
    Iterable<CafeDaManha> buscarTodos();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO cafe_da_manha (id_colaborador, descricao) VALUES (:id_colaborador, :descricao)")
    int inserir(@Param("id_colaborador") Integer id_colaborador, @Param("descricao") String descricao);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE cafe_da_manha SET id_colaborador = :id_colaborador, descricao = :descricao WHERE id = :id")
    int atualizar(@Param("id_colaborador") Integer id_colaborador, @Param("descricao") String descricao, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cafe_da_manha WHERE id = :id")
    int deletar(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha WHERE id = :id")
    Optional<CafeDaManha> bucarPorId(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha WHERE UPPER(descricao) LIKE UPPER(:descricao)")
    List<CafeDaManha> buscarPorNome(@Param("descricao") String descricao);

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha WHERE UPPER(descricao) = UPPER(:descricao) AND id != :id")
    Optional<CafeDaManha> verificaNomeIgual(@Param("descricao") String descricao, @Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha WHERE UPPER(descricao) = UPPER(:descricao)")
    Optional<CafeDaManha> verificaNomeIgual(@Param("descricao") String descricao);

    @Query(nativeQuery = true, value = "SELECT * FROM cafe_da_manha as c WHERE c.id_colaborador = :id")
    Iterable<CafeDaManha> cafePorIdColabo(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT c.id, c.descricao, c.id_colaborador, colaborador.nome FROM cafe_da_manha " +
                                        "as c INNER JOIN colaborador " +
                                        "ON c.id_colaborador = colaborador.id WHERE UPPER(colaborador.nome) LIKE UPPER(:nome) ORDER BY id")
    Iterable<CafeDaManha> cafePorNomeColaborador(@Param("nome")String nome);

}
