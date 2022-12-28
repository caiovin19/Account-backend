package br.com.banco.controller;
import br.com.banco.controller.exception.ResourceExceptionHandler;
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


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Conta> dadosDaConta(@PathVariable Integer id) throws Exception {

            Conta obj = service.findById(id);
            List<Conta> conta = new ArrayList<>();
            conta.add(obj);
            Double soma = 0.0;
            for (Conta x : conta) {
                List<Transferencia> transferencia = x.getTransferencias();
                for (Transferencia z : transferencia) {
                    if (z.getTipo()=="SAQUE"|| z.getTipo()=="TRANSFERENCIA") {
                        soma-=z.getValor();

                    } else {
                        soma += z.getValor();
                    }
                }
            }
            obj.setSoma(soma);
            return ResponseEntity.ok().body(obj);
        }
    }

