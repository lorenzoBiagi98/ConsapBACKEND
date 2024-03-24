package com.example.progettoSERVLETCONSAP.service;



import com.example.progettoSERVLETCONSAP.Dto.commessaOs.CommessaOSDto;
import com.example.progettoSERVLETCONSAP.model.CommessaOS;

import java.util.List;

public interface ICommessaOSService {

    CommessaOS saveCommessaOS(CommessaOS commessaOS);
    List<CommessaOS> getCommesseOS();
    CommessaOS getCommessaById(int id);

    CommessaOSDto getCommessaOSById(int id);
    CommessaOS putCommessaOS(CommessaOS commessaOS,int id);
    void deleteCommessaOS(int id);
}
