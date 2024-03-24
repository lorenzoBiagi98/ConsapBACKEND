package com.example.progettoSERVLETCONSAP.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;



@Data
@Entity
public class Richiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int richiestaId;//
    private int richiestaNumeroTicket;//
    private String richiestaOggetto;
    private Date richiestaDataCreazione;
    private Date richiestaDataInserimento;
    private Date richiestaDataStimaFine;
    private Date richiestaDataModifica;
    private String richiestaUtenteInserimento;
    private String richiestaUtenteModifica;
    private BigDecimal importo;
    @ManyToOne
    @JoinColumn(name="richiestaApplicativoId", referencedColumnName="applicativoId")
    private Applicativo applicativo;
    @ManyToOne
    @JoinColumn(name="richiestaStatoRichiestaCONSAPId", referencedColumnName="statoRichiestaCONSAPId")
    private StatoRichiestaCONSAP statoRichiestaCONSAP;
    @ManyToOne
    @JoinColumn(name="richiestaStatoApprovazioneCONSAPId",
            referencedColumnName="statoApprovazioneCONSAPId")
    private StatoApprovazioneCONSAP statoApprovazioneCONSAP;
    @ManyToOne
    @JoinColumn(name="richiestaStatoApprovazioneOSId",
    referencedColumnName = "statoApprovazioneOSId")
    private StatoApprovazioneOS statoApprovazioneOS;
    @ManyToOne
    @JoinColumn(name="richiestaStatoRichiestaOSId",
    referencedColumnName = "statoRichiestaOSId")
    private StatoRichiestaOS statoRichiestaOS;
    @ManyToOne
    @JoinColumn(name="richiestaCommessaOSId",
    referencedColumnName = "CommessaOSId")
    CommessaOS commessaOS;


}

