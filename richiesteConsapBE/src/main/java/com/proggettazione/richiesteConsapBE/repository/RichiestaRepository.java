package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RichiestaRepository extends JpaRepository<Richiesta,Integer> {

    @Query(value="SELECT * FROM richiesta WHERE richiestaNumeroTicket = :numeroTicket", nativeQuery = true)
    Optional<Richiesta> getRichiestaByNumeroTicket(@Param("numeroTicket") int numeroTicket);

    @Query(value="SELECT * FROM richiesta WHERE richiestaCommessaOSId = :idCommessa", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByIdCommessa(@Param("idCommessa") int idCommessa);
    @Query(value="SELECT * FROM richiesta WHERE richiestaApplicativoId = :idApplicativo", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByIdApplicativo(@Param("idApplicativo") int idApplicativo);
}
