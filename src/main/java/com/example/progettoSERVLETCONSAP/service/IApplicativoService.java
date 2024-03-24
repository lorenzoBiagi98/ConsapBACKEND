package com.example.progettoSERVLETCONSAP.service;


import com.example.progettoSERVLETCONSAP.model.Applicativo;

import java.util.List;

public interface IApplicativoService {

    List<Applicativo> getApplicativi();
    Applicativo saveApplicativo(Applicativo applicativo);
}
