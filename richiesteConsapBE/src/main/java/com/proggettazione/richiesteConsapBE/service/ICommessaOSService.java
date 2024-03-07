package com.proggettazione.richiesteConsapBE.service;

import com.proggettazione.richiesteConsapBE.model.CommessaOS;

import java.util.List;

public interface ICommessaOSService {

    CommessaOS saveCommessaOS(CommessaOS commessaOS);
    List<CommessaOS> getCommesseOS();
    CommessaOS getCommessaById(int id);
    CommessaOS putCommessaOS(CommessaOS commessaOS,int id);
    void deleteCommessaOS(int id);
}
