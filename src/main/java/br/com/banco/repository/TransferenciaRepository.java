package br.com.banco.repository;

import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;;
import java.util.Optional;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

//    public List<Transferencia> findAll();

    @Query(value = "SELECT * FROM transferencia WHERE data_transferencia >= :startDate AND data_transferencia <= :endDate AND conta_id = :id", nativeQuery = true)
    Optional<Transferencia> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("id") Integer id);

}
