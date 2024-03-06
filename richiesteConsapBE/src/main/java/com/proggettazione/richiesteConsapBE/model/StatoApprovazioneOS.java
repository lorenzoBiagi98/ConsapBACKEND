package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StatoApprovazioneOS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoApprovazioneOSId;
    private String statoApprovazioneOSDescrizione;
    private String statoApprovazioneOSUtenteInserimento;
    private String statoApprovazioneOSUtenteModifica;
    private Date statoApprovazioneOSDataInseriento;
    private Date   statoApprovazioneOSDataModifica;

}
