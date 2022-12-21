package br.com.banco;

<<<<<<< HEAD
import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import br.com.banco.repository.ContaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@SpringBootTest
class BancoApplicationTests {

    @Autowired
    private ContaRepository contaRepository;

    @Test
    void contextLoads() {

=======
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BancoApplicationTests {

    @Test
    void contextLoads() {
>>>>>>> refs/remotes/origin/main
    }

}
