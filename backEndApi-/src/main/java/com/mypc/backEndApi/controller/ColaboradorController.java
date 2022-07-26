package com.mypc.backEndApi.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mypc.backEndApi.dto.response.ColabResponse;
import com.mypc.backEndApi.dto.result.ColabResult;
import com.mypc.backEndApi.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController{

    @Autowired
    ColaboradorService cService;

    @GetMapping
    public List<ColabResponse> buscarTodos(){
        List<ColabResponse> colaboradores = new ArrayList<>();
        cService.buscarTodos().iterator().forEachRemaining(colaborador -> {
            colaboradores.add(new ColabResponse(colaborador));
        });

        return colaboradores;
    }

    @GetMapping("/{id_colaborador}")
    public ColabResponse buscaPorId(@PathVariable Integer id){
        
        return new ColabResponse(cService.buscarPorId(id));
    }

    @GetMapping("/buscar_por_nome/{nome}")
    public List<ColabResponse> buscaPorNome(String nome){
        List<ColabResponse> colaboradores = new ArrayList<>();
        cService.buscarPorNome(nome).forEach(colaborador -> {

            colaboradores.add(new ColabResponse(colaborador));
        });
        return colaboradores;
    }

    @PostMapping
    public String inserir(@RequestBody @Valid ColabResult colaboradorDTO) throws ParseException {

        return cService.inserir(colaboradorDTO);
    }

    @PutMapping("/{id}")
    public String atualizar(@RequestBody @Valid ColabResult colaboradorDTO, @PathVariable Integer id) throws ParseException {
        return cService.atualizar(colaboradorDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {

        return cService.deletar(id);
    }
}