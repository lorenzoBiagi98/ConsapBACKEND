package com.proggettazione.richiesteConsapBE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date statoApprovazioneOSDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   statoApprovazioneOSDataModifica;

}
