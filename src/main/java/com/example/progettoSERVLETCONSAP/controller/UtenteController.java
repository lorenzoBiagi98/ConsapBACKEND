package com.example.progettoSERVLETCONSAP.controller;


import com.example.progettoSERVLETCONSAP.model.Utente;
import com.example.progettoSERVLETCONSAP.service.impl.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utente")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UtenteController {
    @Autowired
    UtenteService utenteService;

    @GetMapping
    List<Utente> getAllUtenti(){
        return utenteService.getUtenti();
    }

    @PostMapping
    public ResponseEntity<Utente> saveUtente(@RequestBody Utente utente){
        return new ResponseEntity<Utente>(utenteService.saveUtente(utente), HttpStatus.OK);

    }

}
