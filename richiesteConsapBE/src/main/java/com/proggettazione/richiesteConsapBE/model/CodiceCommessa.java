package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class CodiceCommessa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codiceCommessaId;
    private String codiceCommessaDescrizione;
    private String codiceCommessaUtenteInserimento;
    private String  codiceCommessaUtenteModifica;
    private Date codiceCommessaDataInseriento;
    private Date   codiceCommessaDataModifica;
}
