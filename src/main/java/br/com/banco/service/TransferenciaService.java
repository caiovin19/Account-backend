package br.com.banco.service;

import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService{

    @Autowired
    private TransferenciaRepository repository;
}
