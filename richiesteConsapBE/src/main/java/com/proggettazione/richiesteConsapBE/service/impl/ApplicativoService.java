package com.proggettazione.richiesteConsapBE.service.impl;

import com.proggettazione.richiesteConsapBE.model.Applicativo;
import com.proggettazione.richiesteConsapBE.repository.ApplicativoRepository;
import com.proggettazione.richiesteConsapBE.service.IApplicativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class ApplicativoService implements IApplicativoService {
    Date currentDate = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String formattedDateTimeString = formatter.format(currentDate);
    Date now = formatter.parse(formattedDateTimeString);

    @Autowired
    ApplicativoRepository applicativoRepository;

    public ApplicativoService() throws ParseException {
    }

    @Override
    public List<Applicativo> getApplicativi() {
        return applicativoRepository.findAll();
    }

    @Override
    public Applicativo saveApplicativo(Applicativo applicativo) {
        Applicativo nuovoApplicativo = new Applicativo();
        nuovoApplicativo.setApplicativoDescrizione(applicativo.getApplicativoDescrizione());
        nuovoApplicativo.setApplicativoUtenteInserimento(applicativo.getApplicativoUtenteInserimento());
        nuovoApplicativo.setApplicativoUtenteModifica(applicativo.getApplicativoUtenteModifica());
        nuovoApplicativo.setApplicativoDataInserimento(now);
        nuovoApplicativo.setApplicativoDataModifica(now);

        applicativoRepository.save(nuovoApplicativo);

        return nuovoApplicativo;
    }
}
