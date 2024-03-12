package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneCONSAP;
import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOS;

import java.util.List;

public interface IStatoApprovazioneOSService {
    List<StatoApprovazioneOS> getStatiApprovazioneOS();
    StatoApprovazioneOS saveStatoApprovazioneOS(StatoApprovazioneOS statoApprovazioneOS);


}
