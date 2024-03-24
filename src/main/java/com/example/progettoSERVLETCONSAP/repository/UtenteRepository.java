package com.example.progettoSERVLETCONSAP.repository;


import com.example.progettoSERVLETCONSAP.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Integer> {
}
