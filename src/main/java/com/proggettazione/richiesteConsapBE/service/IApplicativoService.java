package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Applicativo;
import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;

import java.util.List;

public interface IApplicativoService {

    List<Applicativo> getApplicativi();
    Applicativo saveApplicativo(Applicativo applicativo);
}
