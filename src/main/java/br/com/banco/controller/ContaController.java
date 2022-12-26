package br.com.banco.controller;
import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.service.ContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/contas")
public class ContaController {

    @Autowired
    public ContaService service;

//    @CrossOrigin
//    @GetMapping
//    public ResponseEntity<List<Conta>> findAll() {
//        List<Conta> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }

//    @CrossOrigin
//    @GetMapping(value="/{id}")
//    public ResponseEntity<Conta> findById(@PathVariable Integer id){
//       Conta obj= service.findById(id);
//        return ResponseEntity.ok().body(obj);
//   }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> dadosDaConta(@PathVariable Integer id) {
        Conta obj = service.findById(id);
        List<Conta> conta = new ArrayList<>();
        conta.add(obj);
        Double soma=0.0;
        for (Conta x : conta) {
            List<Transferencia> transferencia = x.getTransferencias();
            for (Transferencia z : transferencia) {
                if(z.getValor()>0){
                soma+=z.getValor();}
            }
        }
        obj.setSoma(soma);
        return ResponseEntity.ok().body(obj);
    }
}
