package com.example.progettoSERVLETCONSAP.service.impl;


import com.example.progettoSERVLETCONSAP.model.StatoRichiestaOS;
import com.example.progettoSERVLETCONSAP.repository.StatoRichiestaOSRepository;
import com.example.progettoSERVLETCONSAP.service.IStatoRichiestaOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StatoRichiestaOSService implements IStatoRichiestaOSService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    StatoRichiestaOSRepository statoRichiestaOSRepository;

    public StatoRichiestaOSService() throws ParseException {
    }

    @Override
    public List<StatoRichiestaOS> getStatiRichiestaOS() {
        return statoRichiestaOSRepository.findAll();
    }

    @Override
    public StatoRichiestaOS saveStatoRichiestaOS(StatoRichiestaOS statoRichiestaOS) {

        StatoRichiestaOS nuovoStatoRichiestaOS = new StatoRichiestaOS();

        nuovoStatoRichiestaOS.setStatoRichiestaOSDescrizione(statoRichiestaOS.getStatoRichiestaOSDescrizione());
        nuovoStatoRichiestaOS.setStatoRichiestaOSUtenteInserimento(
                statoRichiestaOS.getStatoRichiestaOSUtenteInserimento());
        nuovoStatoRichiestaOS.setStatoRichiestaOSUtenteModifica(
                statoRichiestaOS.getStatoRichiestaOSUtenteModifica());
        nuovoStatoRichiestaOS.setStatoRichiestaOSDataInserimento(now);
        nuovoStatoRichiestaOS.setStatoRichiestaOSDataModifica(now);

        statoRichiestaOSRepository.save(nuovoStatoRichiestaOS);
        return nuovoStatoRichiestaOS;
    }
}
