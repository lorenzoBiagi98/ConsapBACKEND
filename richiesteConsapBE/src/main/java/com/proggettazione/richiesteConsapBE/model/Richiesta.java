package com.proggettazione.richiesteConsapBE.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Richiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int richiestaId;
    private String richiestaTicket;
    private String richiestaOggetto;
    private Date richiestaDataInserimento;
    private Date richiestaStimaDataFine;
    private Date richiestaDataModifica;
    private String richiestaUtenteInserimento;
    @Column(name = "\"richiestaUtenteModifica\"")
    private String richiestautentemodifica;
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
    @JoinColumn(name="richiestaCodiceCommessaId",
    referencedColumnName = "codiceCommessaId")
    CodiceCommessa codiceCommessa;


}


