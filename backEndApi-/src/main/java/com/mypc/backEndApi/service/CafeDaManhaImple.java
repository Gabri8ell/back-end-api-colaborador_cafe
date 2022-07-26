package com.mypc.backEndApi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mypc.backEndApi.model.CafeDaManha;
import com.mypc.backEndApi.repository.CafeDaManhaRepository;
import com.mypc.backEndApi.repository.ColaboradorRepository;

@Service
public class CafeDaManhaImple implements CafeDaManhaService{

    @Autowired
    CafeDaManhaRepository cfRepository;

    @Autowired
    ColaboradorRepository cbRepository;

    @Override
    public Iterable<CafeDaManha> buscarTodos() {
        return cfRepository.buscarTodos();
        
    }

    @Override
    public String inserir(CafeDaManha cfManha) {
        
        //Verifica se existe colaborador com o id que foi passado 
        if(cbRepository.bucarPorId(cfManha.getColaborador().getId()).isPresent()){
            //verificar se nome refeição já existe busca pelo nome excluindo ela mesma da busca
            if(!cfRepository.verificaNomeIgual(cfManha.getCafeDaManha()).isPresent()){

                cfRepository.inserir(cfManha.getColaborador().getId(), cfManha.getCafeDaManha());
                return "Café da Manha cadastrado com Sucesso!";
            }

            return cfManha.getCafeDaManha() +" já foi cadastro.";
        }

        return "Não existe colaborador com Id: " + cfManha.getColaborador().getId();
    }

    @Override
    public String atualizar(CafeDaManha cfManha, Integer id) {
        //Verificar se id da refeição a editar existe
        if(cfRepository.bucarPorId(id).isPresent()){
            //Verificar se id de quem trará a refeição existe
            if(cbRepository.bucarPorId(cfManha.getColaboradorId()).isPresent()){
                //verificar se nome refeição já existe busca pelo nome excluindo ela mesma da busca
                if(!cfRepository.verificaNomeIgual(cfManha.getCafeDaManha(), cfManha.getId()).isPresent()){

                    cfRepository.atualizar(cfManha.getColaboradorId(), cfManha.getCafeDaManha(), id);

                    return "Refeição Atualizada com sucesso!";
                }
                else{
                    return "Refeição já cadastrada";
                }
            }
            else{
                return "Não existe colaborador com id: " + cfManha.getColaboradorId();
            }
        }
        return "Não existe Refeição com o id: " + id;
    }

    @Override
    public String deletar(Integer id) {
       int result = cfRepository.deletar(id);
        if(result > 0){
            return "Refeição com id: "+ id + " apagada.";
        }

        return "Não existe refeição com id: "+ id;
    }

    @Override
    public List<CafeDaManha> buscarPorNome(String nome) {
        return cfRepository.buscarPorNome(nome);
        
    }

    @Override//Tratar se retornar null
    public Optional<CafeDaManha> buscarPorId(Integer id) {
        // TODO Será que vai ser útil?
        return Optional.empty();
    }

    @Override//Tratar se retornar null
    public Iterable<CafeDaManha> cafePorIdColabo(Integer id) {

        return cfRepository.cafePorIdColabo(id);
        
    }

    @Override//Tratar se retornar null
    public Iterable<CafeDaManha> cafePorNomeColaborador(String nome) {
        return cfRepository.cafePorNomeColaborador(nome);

    }
    
}
