package com.example.progettoSERVLETCONSAP.repository;


import com.example.progettoSERVLETCONSAP.model.StatoRichiestaCONSAP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRichiestaCONSAPRepository extends JpaRepository<StatoRichiestaCONSAP,Integer> {
}
