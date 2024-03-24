package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.StatoRichiestaOS;

import java.util.List;

public interface IStatoRichiestaOSService {

    List<StatoRichiestaOS> getStatiRichiestaOS();
    StatoRichiestaOS saveStatoRichiestaOS(StatoRichiestaOS statoRichiestaOS);
}
