package com.proggettazione.richiesteConsapBE.service.impl;


import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.repository.CommessaOSRepository;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.repository.StatoRichiestaCONSAPRepository;
import com.proggettazione.richiesteConsapBE.service.IRichiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class RichiestaService implements IRichiestaService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    RichiestaRepository richiestaRepository;

    @Autowired
    CommessaOSRepository commessaOSRepository;

    public RichiestaService() throws ParseException {
    }


    @Override
    public Richiesta saveRichiesta(Richiesta richiesta) {
        Richiesta nuovaRichiesta = new Richiesta();
        nuovaRichiesta.setRichiestaNumeroTicket(richiesta.getRichiestaNumeroTicket());
        nuovaRichiesta.setRichiestaOggetto(richiesta.getRichiestaOggetto());
        nuovaRichiesta.setRichiestaDataInserimento(now);
        nuovaRichiesta.setRichiestaDataStimaFine(richiesta.getRichiestaDataStimaFine());
        nuovaRichiesta.setRichiestaDataModifica(now);
        nuovaRichiesta.setRichiestaUtenteInserimento(richiesta.getRichiestaUtenteInserimento());
        nuovaRichiesta.setRichiestaUtenteModifica(richiesta.getRichiestaUtenteModifica());
        nuovaRichiesta.setImporto(richiesta.getImporto());
        nuovaRichiesta.setApplicativo(richiesta.getApplicativo());
        nuovaRichiesta.setStatoRichiestaCONSAP(richiesta.getStatoRichiestaCONSAP());
        nuovaRichiesta.setStatoApprovazioneCONSAP(richiesta.getStatoApprovazioneCONSAP());
        nuovaRichiesta.setStatoApprovazioneOS(richiesta.getStatoApprovazioneOS());
        nuovaRichiesta.setStatoRichiestaOS(richiesta.getStatoRichiestaOS());
        nuovaRichiesta.setCommessaOS(richiesta.getCommessaOS());

        richiestaRepository.save(nuovaRichiesta);

        return nuovaRichiesta;
    }

    @Override
    public List<Richiesta> getRichieste() {
        return richiestaRepository.findAll();
    }

    @Override
    public Richiesta getRichiesta(int id) {
        return richiestaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Richiesta con ID: " + id + " non trovata!!!"));
    }

    @Override
    public Richiesta putRichiesta(Richiesta richiesta, int id) {
        Richiesta richiestaEsistente = richiestaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Richiesta con ID: " + id + " non trovata!!!"));
        richiestaEsistente.setRichiestaNumeroTicket(richiesta.getRichiestaNumeroTicket());
        richiestaEsistente.setRichiestaOggetto(richiesta.getRichiestaOggetto());
        richiestaEsistente.setRichiestaDataInserimento(now);
        richiestaEsistente.setRichiestaDataStimaFine(richiesta.getRichiestaDataStimaFine());
        richiestaEsistente.setRichiestaDataModifica(now);
        richiestaEsistente.setRichiestaUtenteInserimento(richiesta.getRichiestaUtenteInserimento());
        richiestaEsistente.setRichiestaUtenteModifica(richiesta.getRichiestaUtenteModifica());
        richiestaEsistente.setImporto(richiesta.getImporto());
        richiestaEsistente.setApplicativo(richiesta.getApplicativo());
        richiestaEsistente.setStatoRichiestaCONSAP(richiesta.getStatoRichiestaCONSAP());
        richiestaEsistente.setStatoApprovazioneCONSAP(richiesta.getStatoApprovazioneCONSAP());
        richiestaEsistente.setStatoApprovazioneOS(richiesta.getStatoApprovazioneOS());
        richiestaEsistente.setStatoRichiestaOS(richiesta.getStatoRichiestaOS());
        richiestaEsistente.setCommessaOS(richiesta.getCommessaOS());

        richiestaRepository.save(richiestaEsistente);

        return richiestaEsistente;
    }

    @Override
    public void deleteRichiesta(int id) {
        Richiesta richiestaElimina = richiestaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Richiesta con ID: " + id + " non trovata!!!"));

        richiestaRepository.deleteById(id);
    }

    @Override
    public Richiesta getRichiestaByNumeroTicket(int numeroTicket) {
        return richiestaRepository.getRichiestaByNumeroTicket(numeroTicket).orElseThrow(
                () -> new NoSuchElementException(("Ticket numero: " + numeroTicket + " inesistente!!!"))
        );
    }

    @Override
    public List<Richiesta> getRichiesteByIdCommessa(int idCommessa) {
        return richiestaRepository.getRichiestaByIdCommessa(idCommessa).orElseThrow(
                () -> new NoSuchElementException("Commessa numero: " + idCommessa + " non trovata!!!"));
    }

    @Override
    public List<Richiesta> getRichiesteByIdApplicativo(int idApplicativo) {
        return richiestaRepository.getRichiestaByIdApplicativo(idApplicativo).orElseThrow(
                ()-> new NoSuchElementException(("Applicativo numero: " + idApplicativo + " non trovato")));
    }
}
