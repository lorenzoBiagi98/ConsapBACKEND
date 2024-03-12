package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOS;

import java.util.List;

public interface IStatoRichiestaOSService {

    List<StatoRichiestaOS> getStatiRichiestaOS();
    StatoRichiestaOS saveStatoRichiestaOS(StatoRichiestaOS statoRichiestaOS);
}
