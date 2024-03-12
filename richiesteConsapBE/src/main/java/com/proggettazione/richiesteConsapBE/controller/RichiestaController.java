package com.proggettazione.richiesteConsapBE.controller;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.service.impl.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/richiesta")
public class RichiestaController {

    @Autowired
    RichiestaService richiestaServiceImpl;

    @GetMapping("/richieste")
    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    public List<Richiesta> getAllRichieste(){
        return richiestaServiceImpl.getRichieste();
    }

    /*
    @GetMapping("/richiesteFiltro/{idApplicativo}/{idCommessa}/{idTicket}")
    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    public List<Richiesta> getRichiesteFiltro(
            @PathVariable(required = false) Integer idApplicativo,
            @PathVariable(required = false) Integer idCommessa,
            @PathVariable(required = false) Integer idTicket){
        if(idApplicativo != null && idApplicativo > 0 &&
            idCommessa != null && idCommessa > 0 &&
            idTicket != null && idTicket>0) {
            return richiestaServiceImpl.getRichiestaByFiltro(idApplicativo, idCommessa, idTicket);
        }else if(idCommessa == null || idCommessa == 0){
            return richiestaServiceImpl.getRichiestaByApplicativoTicket(idApplicativo, idTicket);
        }else if(idTicket == null || idTicket == 0){
            return richiestaServiceImpl.getRichiesteByApplicativoCommessa(idApplicativo, idCommessa);
        }else if(idApplicativo == null || idApplicativo == 0){
            return richiestaServiceImpl.getRichiestaByCommessaTicket(idCommessa, idTicket);
        }else if(idCommessa == null || idCommessa == 0 && idTicket == null || idTicket == 0){
            return richiestaServiceImpl.getRichiesteByIdApplicativo(idApplicativo);
        }else if(idApplicativo == null || idApplicativo == 0 && idCommessa == null || idCommessa == 0){
            return richiestaServiceImpl.getRichiestaByNumeroTicket(idTicket);
        }else if(idApplicativo == null || idApplicativo == 0 && idTicket == null || idTicket == 0){
            return richiestaServiceImpl.getRichiesteByIdCommessa(idCommessa);
        }
        return  null;
    }

     */

    @GetMapping("/richiesteFiltro/ApplicativoTicket/{idApplicativo}/{idTicket}")
    public List<Richiesta> getRichiesteByApplicativoTicket(@RequestParam Integer idApplicativo,
                                                           @RequestParam Integer idTicket){
        return richiestaServiceImpl.getRichiestaByApplicativoTicket(idApplicativo, idTicket);
    }

    @GetMapping("/richiesteFiltro/ApplicativoCommessa/{idApplicativo}/{idCommessa}")
    public List<Richiesta> getRichiesteByApplicativoCommessa(@RequestParam Integer idApplicativo,
                                                           @RequestParam Integer idCommessa){
        return richiestaServiceImpl.getRichiesteByApplicativoCommessa(idApplicativo, idCommessa);
    }

    /*
    @GetMapping("/richiesteFiltro/CommessaTicket/{idTicket}/{idCommessa}")
    public List<Richiesta> getRichiesteByCommessaTicket(@RequestParam Integer idTicket,
                                                             @RequestParam Integer idCommessa){
        return richiestaServiceImpl.getRichiestaByCommessaTicket(idTicket, idCommessa);
    }

     */


    @GetMapping("/richiesteFiltro/Ticket/{idTicket}")
    public List<Richiesta> getRichiestaByNumeroTicket(
            @PathVariable int idTicket){return richiestaServiceImpl.getRichiestaByNumeroTicket(idTicket);}

    @GetMapping("/richiesteFiltro/Commessa/{idCommessa}")
    public List<Richiesta> getRichiestaByIdCommessa(
            @PathVariable int idCommessa){return richiestaServiceImpl.getRichiesteByIdCommessa(idCommessa);}

    @GetMapping("/richiesteFiltro/Applicativo/{idApplicativo}")
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
