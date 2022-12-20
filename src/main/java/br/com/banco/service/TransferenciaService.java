package br.com.banco.service;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService{

    @Autowired
    private TransferenciaRepository repository;

    public List<Transferencia> findAll(){
        return repository.findAll();
    }

    public Transferencia findById(Integer id) {
        Optional<Transferencia> obj=repository.findById(id);
        return obj.get();
    }
}
