package com.example.progettoSERVLETCONSAP.service.impl;


import com.example.progettoSERVLETCONSAP.Dto.commessaOs.CommessaOSDto;
import com.example.progettoSERVLETCONSAP.model.CommessaOS;
import com.example.progettoSERVLETCONSAP.repository.CommessaOSRepository;
import com.example.progettoSERVLETCONSAP.service.ICommessaOSService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommessaOSService implements ICommessaOSService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    CommessaOSRepository commessaOSRepository;

    public CommessaOSService() throws ParseException {
    }

    @Override
    public CommessaOS saveCommessaOS(CommessaOS commessaOS) {
        CommessaOS nuovaCommessaOS = new CommessaOS();
        nuovaCommessaOS.setCommessaOSCodiceCommessa(commessaOS.getCommessaOSCodiceCommessa());
        nuovaCommessaOS.setCommessaOSDescrizione(commessaOS.getCommessaOSDescrizione());
        nuovaCommessaOS.setCommessaOSUtenteInserimento(commessaOS.getCommessaOSUtenteInserimento());
        nuovaCommessaOS.setCommessaOSUtenteModifica(commessaOS.getCommessaOSUtenteModifica());
        nuovaCommessaOS.setCommessaOSDataInserimento(now);
        nuovaCommessaOS.setCommessaOSDataModifica(now);

        commessaOSRepository.save(nuovaCommessaOS);

        return  nuovaCommessaOS;
    }

    @Override
    public List<CommessaOS> getCommesseOS() {
        return commessaOSRepository.findAll();
    }

    @Override
    public CommessaOS getCommessaById(int id) {
        return commessaOSRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Commessa con ID: " + id + " non trovata!!!"));
        //Fare un ternario per due funzioni all' interno del metodo
    }

    @Override
    public CommessaOSDto getCommessaOSById(int id) {
        CommessaOS commessa = commessaOSRepository.findById(id).orElse(null);
        if(commessa!=null){
            CommessaOSDto commessaOSDto = new CommessaOSDto(
                    commessa.getCommessaOSId(),
                    commessa.getCommessaOSDescrizione(),
                    commessa.getCommessaOSCodiceCommessa()
            );
            return commessaOSDto;
        }else{
            throw  new EntityNotFoundException(String.format("Commessa con id %d non trovata", id));
        }
    }

    @Override
    public CommessaOS putCommessaOS(CommessaOS commessaOS, int id) {

        CommessaOS commessaOSModifica = commessaOSRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException("Commessa con ID: " + id + " non trovata!!!"));

        commessaOSModifica.setCommessaOSCodiceCommessa(commessaOS.getCommessaOSCodiceCommessa());
        commessaOSModifica.setCommessaOSDescrizione(commessaOS.getCommessaOSDescrizione());
        commessaOSModifica.setCommessaOSUtenteInserimento(commessaOS.getCommessaOSUtenteInserimento());
        commessaOSModifica.setCommessaOSUtenteModifica(commessaOS.getCommessaOSUtenteModifica());
        //commessaOSModifica.setCommessaOSDataInserimento(now);
        commessaOSModifica.setCommessaOSDataModifica(now);

        commessaOSRepository.save(commessaOSModifica);

        return commessaOSModifica;
    }

    @Override
    public void deleteCommessaOS(int id) {
    CommessaOS commessaOSElimina = commessaOSRepository.findById(id).orElseThrow(
            ()-> new NoSuchElementException("Commessa con ID: " + id + " non trovata!!!"));

    commessaOSRepository.deleteById(id);
    }
}
