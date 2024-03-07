package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.service.impl.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/richiesta")
public class RichiestaController {

    @Autowired
    RichiestaService richiestaServiceImpl;

    @GetMapping
    public List<Richiesta> getAllRichieste(){
        return richiestaServiceImpl.getRichieste();
    }

    @GetMapping("/numeroTicket/{numeroTicket}")
    public Richiesta getRichiestaByNumeroTicket(
            @PathVariable int numeroTicket){return richiestaServiceImpl.getRichiestaByNumeroTicket(numeroTicket);}

    @GetMapping("/numeroCommessa/{idCommessa}")
    public List<Richiesta> getRichiestaByIdCommessa(
            @PathVariable int idCommessa){return richiestaServiceImpl.getRichiesteByIdCommessa(idCommessa);}

    @GetMapping("/numeroApplicativo/{idApplicativo}")
    public List<Richiesta> getRichiestaByIdApplicativo(
            @PathVariable int idApplicativo){
        return richiestaServiceImpl.getRichiesteByIdApplicativo(idApplicativo);
    }


    @PostMapping
    public ResponseEntity<Richiesta> saveRichiesta(@RequestBody Richiesta richiesta){
        return  new ResponseEntity<Richiesta>(richiestaServiceImpl.saveRichiesta(richiesta), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Richiesta> putRichiesta(@PathVariable int id,
                                                  @RequestBody Richiesta richiesta){
        //int statoId = richiesta.getStato().getId();
       // System.out.println(statoId + "statoID");
        return new ResponseEntity<Richiesta>(richiestaServiceImpl.putRichiesta(richiesta,id
        ),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")    //aaaaaa
    public ResponseEntity<Void> deleteRichiesta(@PathVariable int id){
        System.out.println(("id da cancellare: " + id));
        richiestaServiceImpl.deleteRichiesta(id);
        return ResponseEntity.ok().body(null);
    }


}
