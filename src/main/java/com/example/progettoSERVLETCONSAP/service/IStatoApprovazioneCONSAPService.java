package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.StatoApprovazioneCONSAP;

import java.util.List;

public interface IStatoApprovazioneCONSAPService {

    List<StatoApprovazioneCONSAP> getStatiApprovazioneConsap();
    StatoApprovazioneCONSAP saveStatoApprovazioneCONSAP(StatoApprovazioneCONSAP statoApprovazioneCONSAP);

}
