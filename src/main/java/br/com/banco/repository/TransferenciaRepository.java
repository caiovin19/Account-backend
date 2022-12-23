package br.com.banco.repository;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    public List<Transferencia> findAll();
    String sql1="select data, valor from transferencia"+
            "where conta_id=?"+
            "and Date between ????/??/?? and ????/??/??";

    @Query(value=sql1, nativeQuery = true)
    public List<Transferencia> findByData(Data primeiraData, Data segundaData);






}
