package com.proggettazione.richiesteConsapBE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StatoRichiestaCONSAP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statoRichiestaCONSAPId;
    private String statoRichiestaCONSAPDescrizione;
    private String statoRichiestaCONSAPUtenteInserimento;
    private String statoRichiestaCONSAPUtenteModifica;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   statoRichiestaCONSAPDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   statoRichiestaCONSAPDataModifica;
}
