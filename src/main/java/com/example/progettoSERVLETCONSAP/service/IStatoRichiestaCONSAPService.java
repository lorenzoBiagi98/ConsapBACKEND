package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.StatoRichiestaCONSAP;

import java.util.List;

public interface IStatoRichiestaCONSAPService {
    List<StatoRichiestaCONSAP> getStatiRichiestaCONSAP();
    StatoRichiestaCONSAP saveStatoRichiestaCONSAP(StatoRichiestaCONSAP statoRichiestaCONSAP);
}
