package com.example.progettoSERVLETCONSAP.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StatoRichiestaOS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoRichiestaOSId;
    private String statoRichiestaOSDescrizione;
    private String statoRichiestaOSUtenteInserimento;
    private String statoRichiestaOSUtenteModifica;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date statoRichiestaOSDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   statoRichiestaOSDataModifica;
}
