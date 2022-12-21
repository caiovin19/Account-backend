package br.com.banco.service;

<<<<<<< HEAD
import br.com.banco.entities.Conta;
=======
>>>>>>> refs/remotes/origin/main
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;

=======
>>>>>>> refs/remotes/origin/main
@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;
<<<<<<< HEAD

    public List<Conta> findAll(){
        return repository.findAll();
    }
    public Conta findById(Integer id) {
        Optional<Conta> obj=repository.findById(id);
        return obj.get();
    }

=======
>>>>>>> refs/remotes/origin/main
}
