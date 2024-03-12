package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Richiesta;

import java.util.List;

public interface IRichiestaService {

    Richiesta saveRichiesta(Richiesta richiesta);
    List<Richiesta> getRichieste();
    Richiesta getRichiesta(int id);
    Richiesta putRichiesta(Richiesta richiesta,int id);
    void deleteRichiesta(int id);
    List<Richiesta> getRichiestaByNumeroTicket(int numeroTicket);
    List<Richiesta> getRichiesteByIdCommessa(int idCommessa);
    List<Richiesta> getRichiesteByIdApplicativo(int idApplicativo);
    List<Richiesta> getRichiestaByFiltro(Integer valoreApplicativo, Integer valoreCommessa, Integer valoreTicket);
    List<Richiesta> getRichiestaByApplicativoTicket(Integer valoreApplicativo, Integer valoreTicket);
    List<Richiesta> getRichiesteByApplicativoCommessa(Integer valoreApplicativo, Integer valoreCommessa);
   /*
    List<Richiesta> getRichiestaByCommessaTicket(Integer valorCommessa, Integer valoreTicket);
*/
}
