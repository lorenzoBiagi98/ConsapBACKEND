package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.model.Utente;

import java.util.List;

public interface IUtenteService {

    String getCredenziali(String username, String password);
    List<Utente> getUtenti();
    Utente saveUtente(Utente utente);

}
