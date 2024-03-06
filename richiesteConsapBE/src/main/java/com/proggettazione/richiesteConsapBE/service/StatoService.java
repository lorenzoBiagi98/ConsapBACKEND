package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;

import java.util.List;

public interface StatoService {
    List<StatoRichiestaCONSAP> getStati();
    StatoRichiestaCONSAP saveStato(StatoRichiestaCONSAP statoRichiestaCONSAP);
    StatoRichiestaCONSAP getIdStatoByRichiesta(Richiesta richiesta);
}
