package br.com.banco.controller;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.service.ContaService;
import br.com.banco.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/transferencias")
public class TransferenciaController {


    public TransferenciaService service;

    @GetMapping
    public ResponseEntity<List<Transferencia>> findAll(){
        List<Transferencia>list=service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Transferencia> findById(@PathVariable Long id){
        Transferencia obj= service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
