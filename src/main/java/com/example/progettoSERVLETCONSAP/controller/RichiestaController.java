package com.example.progettoSERVLETCONSAP.controller;


import com.example.progettoSERVLETCONSAP.model.Richiesta;
import com.example.progettoSERVLETCONSAP.repository.RichiestaRepository;
import com.example.progettoSERVLETCONSAP.service.impl.RichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/richiesta")
public class RichiestaController {

    @Autowired
    RichiestaService richiestaServiceImpl;

    @Autowired
    RichiestaRepository richiestaRepository;

    @GetMapping("/richieste")
    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
    /*
    public List<Richiesta> getAllRichieste(){
        return richiestaServiceImpl.getRichieste();
    }
    */
     public Page<Richiesta> getAllRichieste(@RequestParam(required = false)
                                            Optional<Integer> page,
                                            @RequestParam(required = false)
                                            Optional<Integer> size){
         if(page.isPresent() && size.isPresent()){
             Pageable pageable = PageRequest.of(page.get(), size.get());
             Page<Richiesta> paginaRichiesta = richiestaRepository.findAll(pageable);
             return paginaRichiesta;
         }else{
             Page<Richiesta> paginaRichiestaNulla = Page.empty();
             return paginaRichiestaNulla;
         }
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

    @GetMapping("/richieste/filtri")
    public ResponseEntity<List<Richiesta>> ricercaRichieste(
            @RequestParam(required = false) Integer numeroTicket,
            @RequestParam(required = false) String applicativo,
            @RequestParam(required = false) String oggetto,
            @RequestParam(required = false) Long statoRichiestaCONSAPId,
            @RequestParam(required = false) Long statoApprovazioneCONSAPId,
            @RequestParam(required = false) Long statoRichiestaOSId,
            @RequestParam(required = false) Long statoApprovazioneOSId) {

        // Verifica dei parametri e costruzione della query
        Specification<Richiesta> spec = Specification.where(null);

        if (numeroTicket != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("numeroTicket"), numeroTicket));
        }

        if (applicativo != null && !applicativo.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("applicativo"), "%" + applicativo + "%"));
        }

        if (oggetto != null && !oggetto.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("oggetto"), "%" + oggetto + "%"));
        }

        if (statoRichiestaCONSAPId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("statoRichiestaCONSAPId"), statoRichiestaCONSAPId));
        }

        if (statoApprovazioneCONSAPId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("statoApprovazioneCONSAPId"), statoApprovazioneCONSAPId));
        }

        if (statoRichiestaOSId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("statoRichiestaOSId"), statoRichiestaOSId));
        }

        if (statoApprovazioneOSId != null) {
            spec = spec.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("statoApprovazioneOSId"), statoApprovazioneOSId));
        }

        // Esecuzione della query usando il repository
        List<Richiesta> risultati = richiestaRepository.findAll(spec);

        return ResponseEntity.ok(risultati);
    }

    @PostMapping
    public ResponseEntity<Richiesta> saveRichiesta(@RequestBody Richiesta richiesta){
        return  new ResponseEntity<Richiesta>(richiestaServiceImpl.saveRichiesta(richiesta), HttpStatus.OK);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Richiesta> putRichiesta(@PathVariable int id,
                                                  @RequestBody Richiesta richiesta){
        //int statoId = richiesta.getStato().getId();
       // System.out.println(statoId + "statoID")
        return new ResponseEntity<Richiesta>(richiestaServiceImpl.putRichiesta(id,richiesta
        ),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")//aaaaaa
    public ResponseEntity<Void> deleteRichiesta(@PathVariable int id){
        System.out.println(("id da cancellare: " + id));
        richiestaServiceImpl.deleteRichiesta(id);
        return ResponseEntity.ok().body(null);
    }


}
