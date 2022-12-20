package br.com.banco.controller;

import br.com.banco.entities.Conta;
import br.com.banco.service.ContaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/contas")
public class ContaController {

    public ContaService service;

    @GetMapping
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta>list=service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id_conta}")
    public ResponseEntity<Conta> findById(@PathVariable Long id){
        Conta obj= service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
