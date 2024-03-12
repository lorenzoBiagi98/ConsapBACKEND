package com.proggettazione.richiesteConsapBE.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Applicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int applicativoId;
    private String applicativoDescrizione;
    private String applicativoUtenteInserimento;
    private String applicativoUtenteModifica;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date applicativoDataInserimento;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date   applicativoDataModifica;
}
