package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;

import java.util.List;

public interface IStatoRichiestaCONSAPService {
    List<StatoRichiestaCONSAP> getStatiRichiestaCONSAP();
    StatoRichiestaCONSAP saveStatoRichiestaCONSAP(StatoRichiestaCONSAP statoRichiestaCONSAP);
}
