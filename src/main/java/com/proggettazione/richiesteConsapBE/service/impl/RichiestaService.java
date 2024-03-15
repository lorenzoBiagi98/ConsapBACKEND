package com.proggettazione.richiesteConsapBE.service.impl;



import com.proggettazione.richiesteConsapBE.model.Richiesta;
import com.proggettazione.richiesteConsapBE.repository.CommessaOSRepository;
import com.proggettazione.richiesteConsapBE.repository.RichiestaRepository;
import com.proggettazione.richiesteConsapBE.repository.StatoRichiestaCONSAPRepository;
import com.proggettazione.richiesteConsapBE.service.IRichiestaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
        try{
            nuovaRichiesta.setRichiestaNumeroTicket(richiesta.getRichiestaNumeroTicket());
        }catch (Exception err){
            System.err.println("Valore non valido per il NUMERO TICKET!");
        }
        try{
            nuovaRichiesta.setRichiestaOggetto(richiesta.getRichiestaOggetto());
        }catch (Exception err){
            System.err.println("Valore non valido per l' OGGETTO!");
        }
        nuovaRichiesta.setRichiestaDataCreazione(richiesta.getRichiestaDataCreazione());
        nuovaRichiesta.setRichiestaDataInserimento(now);
        nuovaRichiesta.setRichiestaDataStimaFine(richiesta.getRichiestaDataStimaFine());
        nuovaRichiesta.setRichiestaDataModifica(now);
        nuovaRichiesta.setRichiestaUtenteInserimento(richiesta.getRichiestaUtenteInserimento());
        nuovaRichiesta.setRichiestaUtenteModifica(richiesta.getRichiestaUtenteModifica());
        try{
            nuovaRichiesta.setImporto(richiesta.getImporto());
        }catch (Exception err){
            System.err.println("Valore non valido per l' IMPORTO!");
        }
        try{
            nuovaRichiesta.setApplicativo(richiesta.getApplicativo());
        }catch (Exception err){
            System.err.println("Questo APPLICATIVO non esiste!");
        }

        try{
            nuovaRichiesta.setStatoRichiestaCONSAP(richiesta.getStatoRichiestaCONSAP());
        }catch (Exception err){
            System.err.println("Questo STATO RICHIESTA CONSAP non esiste!");
        }

        try{
            nuovaRichiesta.setStatoApprovazioneCONSAP(richiesta.getStatoApprovazioneCONSAP());
        }catch (Exception err){
            System.err.println("Questo STATO APPROVAZIONE CONSAP non esiste!");
        }

        try{
            nuovaRichiesta.setStatoApprovazioneOS(richiesta.getStatoApprovazioneOS());
        }catch (Exception err){
            System.err.println("Questo STATO APPROVAZIONE OS non esiste!");
        }

        try{
            nuovaRichiesta.setStatoRichiestaOS(richiesta.getStatoRichiestaOS());
        }catch (Exception err){
            System.err.println("Questo STATO RICHIESTA OS non esiste!");
        }

        try{
            nuovaRichiesta.setCommessaOS(richiesta.getCommessaOS());
        }catch(Exception err){
            System.err.println("Questa COMMESSA OS non esiste!");
        }

        try{
            richiestaRepository.save(nuovaRichiesta);
        }catch (Exception err){
            System.err.println("Non è stato possibile salvare la RICHIESTA nel db, forse manca" +
                    " qualcosa!");
        }

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
    public Richiesta putRichiesta(int id, Richiesta richiesta) {
        Richiesta richiestaEsistente = richiestaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Richiesta con ID: " + id + " non trovata!!!"));
        if(richiestaEsistente!= null) {
            //richiestaEsistente.setRichiestaNumeroTicket(richiesta.getRichiestaNumeroTicket());
            //richiestaEsistente.setRichiestaOggetto(richiesta.getRichiestaOggetto());
            //richiestaEsistente.setRichiestaDataInserimento(now);
            //richiestaEsistente.setRichiestaDataCreazione(now);
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

            //Data, numero ticket e oggetto

            richiestaRepository.save(richiestaEsistente);

            return richiestaEsistente;
        }
        else {
            throw  new EntityNotFoundException(String.format("Commessa con id %d non trovata", id));
        }
    }

    @Override
    public void deleteRichiesta(int id) {
        Richiesta richiestaElimina = richiestaRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Richiesta con ID: " + id + " non trovata!!!"));
    if(richiestaElimina != null) {
        richiestaRepository.deleteById(id);
    }else{
        throw new EntityNotFoundException(String.format("Richiesta con id %d non trovata",id));
    }

    }

    @Override
    public List<Richiesta> getRichiestaByNumeroTicket(int numeroTicket) {
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

    @Override
    public List<Richiesta> getRichiestaByFiltro(Integer valoreApplicativo, Integer valoreCommessa, Integer valoreTicket) {
        return richiestaRepository.getRichiestaByApplicativoCommessaTIcket(
                valoreApplicativo,valoreCommessa,valoreTicket).orElseThrow(
                        ()->new NoSuchElementException(("Richiesta non trovata"))
        );
    }

    @Override
    public List<Richiesta> getRichiestaByApplicativoTicket(Integer valoreApplicativo, Integer valoreTicket) {
        return richiestaRepository.getRichiestaByApplicativoTicket(valoreApplicativo, valoreTicket)
                .orElseThrow(()-> new NoSuchElementException("Richiesta non trovata"));
    }

    @Override
    public List<Richiesta> getRichiesteByApplicativoCommessa(Integer valoreApplicativo, Integer valoreCommessa) {
        return richiestaRepository.getRichiesteApplicativoCommessa(valoreApplicativo, valoreCommessa)
                .orElseThrow(
                        ()->new NoSuchElementException("Richiesta non trovata"));
    }

    /*
    @Override
    public List<Richiesta> getRichiestaByCommessaTicket(Integer idTicket, Integer valoreCommessa) {
        return richiestaRepository.getRichiestaByCommessaTicket(idTicket, valoreCommessa)
                .orElseThrow(
                ()->new NoSuchElementException("Richiesta non trovata"));
    }
*/

}
