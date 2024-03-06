package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StatoRichiestaCONSAP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoRichiestaCONSAPId;
    private String descrizione;
    private String statoRichiestaCONSAPUtenteInserimento;
    private String statoRichiestaCONSAPUtenteModifica;
    private Date   statoRichiestaCONSAPDataInseriento;
    private Date   statoRichiestaCONSAPDataModifica;
}
