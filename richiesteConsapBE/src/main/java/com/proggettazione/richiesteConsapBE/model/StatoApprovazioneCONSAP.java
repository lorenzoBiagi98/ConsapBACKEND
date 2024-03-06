package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StatoApprovazioneCONSAP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoApprovazioneCONSAPId;
    private String statoApprovazioneCONSAPDescrizione;
    private String statoApprovazioneCONSAPUtenteInserimento;
    private String statoApprovazioneCONSAPUtenteModifica;
    private Date statoApprovazioneCONSAPDataInseriento;
    private Date   statoApprovazioneCONSAPDataModifica;
}
