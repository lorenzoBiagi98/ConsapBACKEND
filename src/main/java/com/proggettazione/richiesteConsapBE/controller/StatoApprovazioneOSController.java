package com.proggettazione.richiesteConsapBE.controller;


import com.proggettazione.richiesteConsapBE.model.StatoApprovazioneOS;
import com.proggettazione.richiesteConsapBE.service.impl.StatoApprovazioneOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statoApprovazioneOS")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class StatoApprovazioneOSController {

    @Autowired
    StatoApprovazioneOSService statoApprovazioneOSService;

    @GetMapping
    public List<StatoApprovazioneOS> getStatiApprovazioneOS(){
        return statoApprovazioneOSService.getStatiApprovazioneOS(); }

    @PostMapping
    public ResponseEntity<StatoApprovazioneOS> saveStatoApprovazioneOS(
            @RequestBody StatoApprovazioneOS statoApprovazioneOS){
        return new ResponseEntity<StatoApprovazioneOS>(
                statoApprovazioneOSService.saveStatoApprovazioneOS(statoApprovazioneOS),
                HttpStatus.OK);
    }
}
