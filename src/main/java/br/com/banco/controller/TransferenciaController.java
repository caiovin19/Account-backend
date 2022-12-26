package br.com.banco.controller;

import br.com.banco.controller.URL.URL;
import br.com.banco.controller.dto.DateDto;
import br.com.banco.entities.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
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
    @Autowired
    private TransferenciaRepository transferenciaRepository;



    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public ResponseEntity<List<Transferencia>> findAll() {
        List<Transferencia> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
 @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value="/{id}")
   public ResponseEntity<Transferencia> findById(@PathVariable Integer id){
       Transferencia obj= service.findById(id);
       return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/data/{id}")
    public ResponseEntity<Object> findTranferenciasPorData(@RequestBody DateDto dateDto, @PathVariable Integer id) throws Exception {

        URL start1 = new URL();
        Date start = start1.convertDate(dateDto.getStartDate());

        URL end1 = new URL();
        Date end = end1.convertDate(dateDto.getEndDate());

        Optional<Transferencia> trasferencias = transferenciaRepository.getAllBetweenDates(start, end, id);
        if(!trasferencias.isPresent()){
            throw new Exception("Período não encontrado");}


        return ResponseEntity.ok(trasferencias);

    }
}