package com.example.progettoSERVLETCONSAP.service.impl;

import com.example.progettoSERVLETCONSAP.model.StatoApprovazioneOS;
import com.example.progettoSERVLETCONSAP.repository.StatoApprovazioneOSRepository;
import com.example.progettoSERVLETCONSAP.service.IStatoApprovazioneOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StatoApprovazioneOSService implements IStatoApprovazioneOSService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    StatoApprovazioneOSRepository statoApprovazioneOSRepository;

    public StatoApprovazioneOSService() throws ParseException {
    }

    @Override
    public List<StatoApprovazioneOS> getStatiApprovazioneOS() {
        return statoApprovazioneOSRepository.findAll();
    }

    @Override
    public StatoApprovazioneOS saveStatoApprovazioneOS(StatoApprovazioneOS statoApprovazioneOS) {
        StatoApprovazioneOS nuovoStatoApprovazioneOS = new StatoApprovazioneOS();

        nuovoStatoApprovazioneOS.setStatoApprovazioneOSDescrizione(
                statoApprovazioneOS.getStatoApprovazioneOSDescrizione());
        nuovoStatoApprovazioneOS.setStatoApprovazioneOSUtenteInserimento(
                statoApprovazioneOS.getStatoApprovazioneOSUtenteInserimento());
        nuovoStatoApprovazioneOS.setStatoApprovazioneOSUtenteModifica(
                statoApprovazioneOS.getStatoApprovazioneOSUtenteModifica());
        nuovoStatoApprovazioneOS.setStatoApprovazioneOSDataInserimento(now);
        nuovoStatoApprovazioneOS.setStatoApprovazioneOSDataModifica(now);

        statoApprovazioneOSRepository.save(nuovoStatoApprovazioneOS);
        return nuovoStatoApprovazioneOS;
    }
}
