package com.example.progettoSERVLETCONSAP.controller;

import com.example.progettoSERVLETCONSAP.model.Applicativo;
import com.example.progettoSERVLETCONSAP.service.impl.ApplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicativo")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ApplicativoController {

    @Autowired
    ApplicativoService applicativoService;

    @GetMapping
    public List<Applicativo> getApplicativi(){return applicativoService.getApplicativi();}

    @PostMapping
    public ResponseEntity<Applicativo> saveApplicativo(@RequestBody Applicativo applicativo){
        return new ResponseEntity<Applicativo>(applicativoService.saveApplicativo(applicativo),
                HttpStatus.OK);
    }
}
