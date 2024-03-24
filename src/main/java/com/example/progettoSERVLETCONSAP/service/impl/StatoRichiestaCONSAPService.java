package com.example.progettoSERVLETCONSAP.service.impl;


import com.example.progettoSERVLETCONSAP.model.StatoRichiestaCONSAP;
import com.example.progettoSERVLETCONSAP.repository.RichiestaRepository;
import com.example.progettoSERVLETCONSAP.repository.StatoRichiestaCONSAPRepository;
import com.example.progettoSERVLETCONSAP.service.IStatoRichiestaCONSAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StatoRichiestaCONSAPService implements IStatoRichiestaCONSAPService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    RichiestaRepository richiestaRepository;

    @Autowired
    StatoRichiestaCONSAPRepository statoRichiestaCONSAPRepository;

    public StatoRichiestaCONSAPService() throws ParseException {
    }


    @Override
    public List<StatoRichiestaCONSAP> getStatiRichiestaCONSAP() {
        return statoRichiestaCONSAPRepository.findAll();
    }

    @Override
    public StatoRichiestaCONSAP saveStatoRichiestaCONSAP(StatoRichiestaCONSAP statoRichiestaCONSAP) {
        StatoRichiestaCONSAP nuovoStatoRichiestaCONSAP = new StatoRichiestaCONSAP();
        nuovoStatoRichiestaCONSAP.setStatoRichiestaCONSAPDescrizione((
                statoRichiestaCONSAP.getStatoRichiestaCONSAPDescrizione()));
        nuovoStatoRichiestaCONSAP.setStatoRichiestaCONSAPUtenteInserimento(
                statoRichiestaCONSAP.getStatoRichiestaCONSAPUtenteInserimento());
        nuovoStatoRichiestaCONSAP.setStatoRichiestaCONSAPUtenteModifica(
                statoRichiestaCONSAP.getStatoRichiestaCONSAPUtenteModifica());
        nuovoStatoRichiestaCONSAP.setStatoRichiestaCONSAPDataInserimento(now);
        nuovoStatoRichiestaCONSAP.setStatoRichiestaCONSAPDataModifica(now);

        statoRichiestaCONSAPRepository.save(nuovoStatoRichiestaCONSAP);

        return nuovoStatoRichiestaCONSAP;
    }

}