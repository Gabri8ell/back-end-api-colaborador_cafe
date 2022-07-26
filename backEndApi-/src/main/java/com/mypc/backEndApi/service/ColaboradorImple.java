package com.mypc.backEndApi.service;

import com.mypc.backEndApi.dto.result.ColabResult;
import com.mypc.backEndApi.model.Colaborador;
import com.mypc.backEndApi.repository.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.List;


@Service
public class ColaboradorImple implements ColaboradorService{
    @Autowired
    ColaboradorRepository cRepository;

    @Override
    public Iterable<Colaborador> buscarTodos() {
        return cRepository.buscarTodos();
    }

    @Override
    public String inserir(ColabResult colaboradorDTO) throws ParseException {
            colaboradorDTO.setCpf(formatarString(colaboradorDTO.getCpf()));
        
        if(!cRepository.verificaCpf(colaboradorDTO.getCpf()).isPresent()){
            cRepository.inserir(colaboradorDTO.getNome(), colaboradorDTO.getCpf());

            return "Colaborador criado com sucesso";
        }

        return "Colaborador Já Cadastrado";
    }

    @Override
    public String atualizar(ColabResult colaboradorDTO, Integer id) throws ParseException {
        colaboradorDTO.setCpf(formatarString(colaboradorDTO.getCpf()));

        if(verificarSeExiste(id)){
            //Se existir, retorna algum objeto que tenha o cpf igua e id diferente do que será atualizado
            if(!cRepository.verificaCpf(colaboradorDTO.getCpf(), id).isPresent()){
                Colaborador colabParaSalvar = new Colaborador(colaboradorDTO);
                colabParaSalvar.setId(id);
                cRepository.atualizar(colabParaSalvar.getNome(), colabParaSalvar.getCpf(), colabParaSalvar.getId());

                return "Colaborador com id: "+ id + " atualizado.";
            }
            return "Colaborador já cadastrado";

        } else{

            return "Id inválido";
        }
    }

    @Override
    public String deletar(Integer id){
        int result = cRepository.deletar(id);
        if(result > 0){
            return "Colaborador com id: "+ id + " apagado.";
        }

        return "Não existe colaborador com id: "+ id;
    }

    @Override
    public List<Colaborador> buscarPorNome(String nome) {
        return cRepository.buscarPorNome(nome);
    }

    @Override
    public Colaborador buscarPorId(Integer id) {
        return cRepository.bucarPorId(id).orElse(null);
    }

    //Verifica se o Colaborador Existe
    private Boolean verificarSeExiste(Integer id){
        return cRepository.bucarPorId(id).isPresent();
    }

    //Formata a String para CPF
    private static String formatarString(String texto) throws ParseException {
        String t1 = texto.replace(".", "").replace("-", "").replace(" ", "");

        MaskFormatter mf = new MaskFormatter("###.###.###-##");
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(t1);
    }
}