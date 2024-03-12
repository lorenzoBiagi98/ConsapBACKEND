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
    Optional<List<Richiesta>> getRichiestaByNumeroTicket(@Param("numeroTicket") int numeroTicket);

    @Query(value="SELECT * FROM richiesta WHERE richiestaCommessaOSId = :idCommessa", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByIdCommessa(@Param("idCommessa") int idCommessa);
    @Query(value="SELECT * FROM richiesta WHERE richiestaApplicativoId = :idApplicativo", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByIdApplicativo(@Param("idApplicativo") int idApplicativo);

    /*
    @Query(value="SELECT * FROM Richiesta " +
            "WHERE " +
            "    (richiestaApplicativoId IS NULL OR richiestaApplicativoId = :valoreApplicativo) " +
            "    AND (richiestaCommessaOSId IS NULL OR richiestaCommessaOSId = :valoreCommessa) " +
            "    AND (richiestaNumeroTicket IS NULL OR richiestaNumeroTicket = :valoreTicket)", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByFiltro(@Param("valoreApplicativo") int valoreApplicativo,
                                                   @Param("valoreCommessa") int valoreCommessa,
                                                   @Param("valoreTicket") int valoreTicket);



    // QUERY BY APPLICATIVO, COMMESSA E TICKET                                     */
    @Query(value="SELECT * FROM Richiesta WHERE richiestaApplicativoId = :valoreApplicativo AND " +
            "richiestaCommessaOSId = :valoreCommessaOS AND richiestaNumeroTicket = :valoreTicket", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByApplicativoCommessaTIcket(@Param("valoreApplicativo") Integer valoreApplicativo,
                                                                @Param("valoreCommessaOS") Integer valoreCommessaOS,
                                                                @Param("valoreTicket") Integer valoreTicket);

    // QUERY BY APPLICATIVO E TICKET
    @Query(value = "SELECT * FROM Richiesta WHERE richiestaApplicativoId = :valoreApplicativo AND " +
            "richiestaNumeroTicket = :valoreTicket",nativeQuery = true )
    Optional<List<Richiesta>> getRichiestaByApplicativoTicket(@Param("valoreApplicativo") Integer valoreApplicativo,
                                                        @Param("valoreTicket") Integer valoreTicket);

    // QUERY BY APPLICATIVO E COMMESSA
    @Query(value = "SELECT * FROM Richiesta WHERE richiestaApplicativoId = :valoreApplicativo AND " +
            "richiestaCommessaOSId = :valoreCommessa",nativeQuery = true )
    Optional<List<Richiesta>> getRichiesteApplicativoCommessa(@Param("valoreApplicativo") Integer valoreApplicativo,
                                                              @Param("valoreCommessa") Integer valoreCommessa);

    // QUERY BY COMMESSA E TICKET
    /*
    @Query(value="SELECT * FROM Richiesta where richiestaNumeroTicket = :valoreTicket AND richiestaCommessaOSId = :idCommessa",
    nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByCommessaTicket(@Param("idTicket") Integer idCommessa,
                                                        @Param("valoreTicket") Integer valoreTicket);


*/


/*
    @Query(value="SELECT * FROM Richiesta " +
            "WHERE" +
            "    (:valoreApplicativo IS NULL OR richiestaApplicativoId = :valoreApplicativo)" +
            "    AND (:valoreCommessa IS NULL OR richiestaCommessaOSId = :valoreCommessa)" +
            "    AND (:valoreTicket IS NULL OR richiestaNumeroTicket = :valoreTicket)" +
            "    AND ((:valoreApplicativo IS NOT NULL AND :valoreCommessa IS NULL AND :valoreTicket IS NULL) " +
            "        OR (:valoreApplicativo IS NULL AND :valoreCommessa IS NOT NULL AND :valoreTicket IS NULL) " +
            "        OR (:valoreApplicativo IS NULL AND :valoreCommessa IS NULL AND :valoreTicket IS NOT NULL))", nativeQuery = true)
    Optional<List<Richiesta>> getRichiestaByFiltro(@Param("valoreApplicativo") Integer valoreApplicativo,
                                                   @Param("valoreCommessa") Integer valoreCommessa,
                                                   @Param("valoreTicket") Integer valoreTicket);
*/





}
