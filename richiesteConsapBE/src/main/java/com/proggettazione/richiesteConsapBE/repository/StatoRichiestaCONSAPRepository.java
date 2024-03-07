package com.proggettazione.richiesteConsapBE.repository;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoRichiestaCONSAPRepository extends JpaRepository<StatoRichiestaCONSAP,Integer> {
}
