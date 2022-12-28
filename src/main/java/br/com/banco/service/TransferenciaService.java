package br.com.banco.service;

import br.com.banco.controller.dto.DateDto;
import br.com.banco.entities.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository repository;

    public List<Transferencia> findAll(){
        return repository.findAll();
    }

//    public Transferencia findById(Integer id) {
//        Optional<Transferencia> obj=repository.findById(id);
//        return obj.get();}

    public List<Transferencia> getAllBetweenDates(Date startDate, Date endDate, Integer id) {

        List<Transferencia> trasferencias = repository.getAllBetweenDates(startDate, endDate, id);
        return trasferencias;
    }
}
