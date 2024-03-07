package com.proggettazione.richiesteConsapBE.controller;


import com.proggettazione.richiesteConsapBE.model.CommessaOS;
import com.proggettazione.richiesteConsapBE.service.impl.CommessaOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commessaOS")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CommessaOSController {

    @Autowired
    CommessaOSService commessaOSService;

    @GetMapping
    public List<CommessaOS> getAllCommesseOS(){return commessaOSService.getCommesseOS();}

    @PostMapping
    public ResponseEntity<CommessaOS> saveCommessaOS(@RequestBody CommessaOS commessaOS){
        return new ResponseEntity<CommessaOS>(commessaOSService.saveCommessaOS(commessaOS)
                , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommessaOS> putCommessaOS(@RequestBody CommessaOS commessaOS,
                                                    @PathVariable int id
    ){
        return new ResponseEntity<CommessaOS>(commessaOSService.putCommessaOS(commessaOS, id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommessa(@PathVariable int id){
        commessaOSService.deleteCommessaOS(id);
        return ResponseEntity.ok().body(null);
    }
}
