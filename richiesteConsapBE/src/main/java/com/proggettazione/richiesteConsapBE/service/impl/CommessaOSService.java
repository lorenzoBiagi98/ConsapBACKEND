package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.CommessaOS;
import com.proggettazione.richiesteConsapBE.repository.CommessaOSRepository;
import com.proggettazione.richiesteConsapBE.service.ICommessaOSService;
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
