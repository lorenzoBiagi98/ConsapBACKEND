package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;

import java.util.List;

public interface IRichiestaService {

    Richiesta saveRichiesta(Richiesta richiesta);
    List<Richiesta> getRichieste();
    Richiesta getRichiesta(int id);
    Richiesta putRichiesta(Richiesta richiesta,int id);
    void deleteRichiesta(int id);
    Richiesta getRichiestaByNumeroTicket(int numeroTicket);
    List<Richiesta> getRichiesteByIdCommessa(int idCommessa);
    List<Richiesta> getRichiesteByIdApplicativo(int idApplicativo);
}
