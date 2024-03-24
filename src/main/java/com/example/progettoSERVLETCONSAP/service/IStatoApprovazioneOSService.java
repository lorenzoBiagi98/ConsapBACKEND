package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.StatoApprovazioneOS;

import java.util.List;

public interface IStatoApprovazioneOSService {
    List<StatoApprovazioneOS> getStatiApprovazioneOS();
    StatoApprovazioneOS saveStatoApprovazioneOS(StatoApprovazioneOS statoApprovazioneOS);


}
