package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneCONSAP;
import com.proggettazione.richiesteConsapBE.service.impl.StatoApprovazioneCONSAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statoApprovazioneCONSAP")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StatoApprovazioneCONSAPController {

    @Autowired
    StatoApprovazioneCONSAPService statoApprovazioneCONSAPService;

    @GetMapping
    public List<StatoApprovazioneCONSAP> getStatiApprovazioneCONSAP(){
        return statoApprovazioneCONSAPService.getStatiApprovazioneConsap();}

    @PostMapping
    public ResponseEntity<StatoApprovazioneCONSAP> saveStatoApprovazioneCONSAP(
            @RequestBody StatoApprovazioneCONSAP statoApprovazioneCONSAP){
        return new ResponseEntity<StatoApprovazioneCONSAP>(
                statoApprovazioneCONSAPService.saveStatoApprovazioneCONSAP(statoApprovazioneCONSAP),
                HttpStatus.OK);
    }
}