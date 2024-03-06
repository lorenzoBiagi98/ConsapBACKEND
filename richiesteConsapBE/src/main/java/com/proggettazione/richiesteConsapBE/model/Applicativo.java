package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Applicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicativoId;
    private String applicativoDescrizione;
    private String applicativoUtenteInserimento;
    private String applicativoUtenteModifica;
    private Date applicativoDataInseriento;
    private Date   applicativoDataModifica;
}
