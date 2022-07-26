package com.mypc.backEndApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mypc.backEndApi.dto.response.CafeManhaResponse;
import com.mypc.backEndApi.dto.result.CafeManhaResult;
import com.mypc.backEndApi.model.CafeDaManha;
import com.mypc.backEndApi.model.JoinColumn;
import com.mypc.backEndApi.service.CafeDaManhaService;

@RestController
@RequestMapping("/cafedamanha")
public class CafeDaManhaController{

    @Autowired
    CafeDaManhaService cfService;

    @GetMapping
    public List<CafeManhaResponse> buscarTodos(){
        List<CafeManhaResponse> cfsManha = new ArrayList<>();
        cfService.buscarTodos().iterator().forEachRemaining( cafe -> {
            cfsManha.add(new CafeManhaResponse(cafe));
        });

        return cfsManha;
    }

    @PostMapping
    public String inserir(@RequestBody CafeManhaResult cfManhaDTO){

        return cfService.inserir(new CafeDaManha(cfManhaDTO));
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable Integer id, @RequestBody CafeManhaResult cfManhaDTO){
        return cfService.atualizar(new CafeDaManha(cfManhaDTO), id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        return cfService.deletar(id);
    }

    @GetMapping("/buscar_por_nome/{nome}")
    public List<CafeManhaResponse> buscarPorNome(@PathVariable String nome){
        List<CafeManhaResponse> cfResponse = cfService.buscarPorNome(nome).stream()
        .map(cafe -> new CafeManhaResponse(cafe)).collect(Collectors.toList());

        return cfResponse;
    }

    @GetMapping("/buscar_pelo_colaborador/{nome}")
    public List<JoinColumn> buscarPeloColaborador(@PathVariable String nome){
        List<JoinColumn> join = new ArrayList<>(); 
        cfService.cafePorNomeColaborador(nome).iterator().forEachRemaining(obj -> {
            join.add(new JoinColumn(obj));
        });

        return join;
    }

    @GetMapping("/{idColaborador}")
    public List<CafeManhaResponse> buscarCafePorIdColaborador(@PathVariable("idColaborador") Integer id){
        List<CafeManhaResponse> cfResponse = new ArrayList<>();

        cfService.cafePorIdColabo(id).forEach(cafe -> {
            cfResponse.add(new CafeManhaResponse(cafe));
        });

        return cfResponse;
    }
}