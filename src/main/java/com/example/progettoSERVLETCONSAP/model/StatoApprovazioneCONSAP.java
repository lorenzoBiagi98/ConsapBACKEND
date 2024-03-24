package com.example.progettoSERVLETCONSAP.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date statoApprovazioneCONSAPDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   statoApprovazioneCONSAPDataModifica;
}
