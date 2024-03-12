package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoRichiestaCONSAP;
import com.proggettazione.richiesteConsapBE.service.impl.StatoRichiestaCONSAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statoRichiestaCONSAP")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StatoRichiestaCONSAPController {

    @Autowired
    StatoRichiestaCONSAPService statoRichiestaCONSAPService;


    @GetMapping
    List<StatoRichiestaCONSAP> getAllStati(){
        return statoRichiestaCONSAPService.getStatiRichiestaCONSAP();
    }

    @PostMapping
    public ResponseEntity<StatoRichiestaCONSAP> saveStato(@RequestBody StatoRichiestaCONSAP statoRichiestaCONSAP){
        return new ResponseEntity<StatoRichiestaCONSAP>(
                statoRichiestaCONSAPService.saveStatoRichiestaCONSAP(statoRichiestaCONSAP),
                HttpStatus.OK);
    }
}
