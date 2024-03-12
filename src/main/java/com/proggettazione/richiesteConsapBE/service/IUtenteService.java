package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.Utente;

import java.util.List;

public interface IUtenteService {

    String getCredenziali(String username, String password);
    List<Utente> getUtenti();
    Utente saveUtente(Utente utente);

}
