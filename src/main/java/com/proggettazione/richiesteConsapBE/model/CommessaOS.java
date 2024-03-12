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
public class CommessaOS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CommessaOSId;
    private String CommessaOSCodiceCommessa;
    private String CommessaOSDescrizione;
    private String CommessaOSUtenteInserimento;
    private String  CommessaOSUtenteModifica;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date CommessaOSDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   CommessaOSDataModifica;
}
