package com.example.progettoSERVLETCONSAP.service.impl;


import com.example.progettoSERVLETCONSAP.model.StatoApprovazioneCONSAP;
import com.example.progettoSERVLETCONSAP.repository.StatoApprovazioneCONSAPRepository;
import com.example.progettoSERVLETCONSAP.service.IStatoApprovazioneCONSAPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StatoApprovazioneCONSAPService implements IStatoApprovazioneCONSAPService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    StatoApprovazioneCONSAPRepository statoApprovazioneCONSAPRepository;

    public StatoApprovazioneCONSAPService() throws ParseException {
    }

    @Override
    public List<StatoApprovazioneCONSAP> getStatiApprovazioneConsap() {
        return statoApprovazioneCONSAPRepository.findAll();
    }

    @Override
    public StatoApprovazioneCONSAP saveStatoApprovazioneCONSAP(StatoApprovazioneCONSAP statoApprovazioneCONSAP) {
        StatoApprovazioneCONSAP nuovoStatoApprovazioneCONSAP = new StatoApprovazioneCONSAP();
        nuovoStatoApprovazioneCONSAP.setStatoApprovazioneCONSAPDescrizione(
                statoApprovazioneCONSAP.getStatoApprovazioneCONSAPDescrizione());
        nuovoStatoApprovazioneCONSAP.setStatoApprovazioneCONSAPUtenteInserimento(
                statoApprovazioneCONSAP.getStatoApprovazioneCONSAPUtenteInserimento());
        nuovoStatoApprovazioneCONSAP.setStatoApprovazioneCONSAPUtenteModifica(
                statoApprovazioneCONSAP.getStatoApprovazioneCONSAPUtenteModifica());
        nuovoStatoApprovazioneCONSAP.setStatoApprovazioneCONSAPDataInserimento(now);
        nuovoStatoApprovazioneCONSAP.setStatoApprovazioneCONSAPDataModifica(now);

        statoApprovazioneCONSAPRepository.save(nuovoStatoApprovazioneCONSAP);
        return nuovoStatoApprovazioneCONSAP;
    }
}
