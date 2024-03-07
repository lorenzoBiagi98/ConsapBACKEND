package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneCONSAP;

import java.util.List;

public interface IStatoApprovazioneCONSAPService {

    List<StatoApprovazioneCONSAP> getStatiApprovazioneConsap();
    StatoApprovazioneCONSAP saveStatoApprovazioneCONSAP(StatoApprovazioneCONSAP statoApprovazioneCONSAP);
}
