package com.mypc.backEndApi.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mypc.backEndApi.model.Colaborador;

//@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM colaborador")
    Iterable<Colaborador> buscarTodos();

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO colaborador (nome, cpf) VALUES (:nome, :cpf)")
    int inserir(@Param("nome") String nome, @Param("cpf") String cpf);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE colaborador SET nome= :nome, cpf= :cpf WHERE id= :id")
    int atualizar(@Param("nome") String nome, @Param("cpf") String cpf, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM colaborador WHERE id= :id")
    int deletar(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM colaborador WHERE id = :id")
    Optional<Colaborador> bucarPorId(@Param("id") Integer id);
    
    @Query(nativeQuery = true, value = "SELECT * FROM colaborador WHERE cpf = :cpf")
    Optional<Colaborador> verificaCpf(@Param("cpf") String cpf);
    
    @Query(nativeQuery = true, value = "SELECT * FROM colaborador WHERE cpf = :cpf AND id != :id")
    Optional<Colaborador> verificaCpf(@Param("cpf") String cpf, @Param("id") Integer id);
    
    @Query(nativeQuery = true, value = "SELECT * FROM colaborador WHERE UPPER(nome) LIKE UPPER(:nome)")
    List<Colaborador> buscarPorNome(@Param("nome") String nome);
}
