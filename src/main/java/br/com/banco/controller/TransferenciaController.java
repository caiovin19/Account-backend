package br.com.banco.controller;

import br.com.banco.controller.URL.URL;
import br.com.banco.controller.dto.DateDto;
import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import br.com.banco.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import br.com.banco.controller.URL.URL;

@RestController
@RequestMapping(value ="/transferencias")
public class TransferenciaController {


    @Autowired
    public TransferenciaService service;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/data/{id}")
    public ResponseEntity<List<Transferencia>> findTranferenciasPorData(@RequestBody DateDto dateDto, @PathVariable Integer id) throws Exception {
        Double somaTransf=0.0;
        URL start1 = new URL();
        Date start = start1.convertDate(dateDto.getStartDate());

        URL end1 = new URL();
        Date end = end1.convertDate(dateDto.getEndDate());

        if(end.after(start)){
            throw new ResourceNotFoundException("Periodo incorreto");
        }
        List<Transferencia> trasferencias = service.getAllBetweenDates(start, end, id);
        for(Transferencia t: trasferencias){
            if (t.getValor()>0) {
                somaTransf += t.getValor();
            }
        }
        Conta conta=null;
        conta.setTotalTransferidoPorPeriodo(somaTransf);


            return ResponseEntity.ok(trasferencias);

    }
}