package com.proggettazione.richiesteConsapBE.controller;


import com.proggettazione.richiesteConsapBE.model.StatoRichiestaOS;
import com.proggettazione.richiesteConsapBE.service.impl.StatoRichiestaOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statoRichiestaOS")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StatoRichiestaOSController {

    @Autowired
    StatoRichiestaOSService statoRichiestaOSService;

    @GetMapping
    public List<StatoRichiestaOS> getStatiRichiestaOS(){
        return statoRichiestaOSService.getStatiRichiestaOS();
    }

    @PostMapping
    public ResponseEntity<StatoRichiestaOS> saveStatoRichiestaOS(@RequestBody StatoRichiestaOS statoRichiestaOS){
        return new ResponseEntity<StatoRichiestaOS>(statoRichiestaOSService.saveStatoRichiestaOS(statoRichiestaOS),
                HttpStatus.OK);
    }
}