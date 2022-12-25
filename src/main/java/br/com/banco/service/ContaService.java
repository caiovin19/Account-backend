package br.com.banco.service;

import br.com.banco.entities.Conta;

import br.com.banco.repository.ContaRepository;
import br.com.banco.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    public List<Conta> findAll(){
        return repository.findAll();
    }
    public Conta findById(Integer id) {
        Optional<Conta> obj=repository.findById(id);
        return obj.orElseThrow(()->new ResourceNotFoundException(id));
    }
}
