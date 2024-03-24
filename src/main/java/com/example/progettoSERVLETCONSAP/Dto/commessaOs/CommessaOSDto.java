package com.example.progettoSERVLETCONSAP.Dto.commessaOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommessaOSDto {
    private int CommessaOSId;
    private String CommessaOSCodiceCommessa;
    private String CommessaOSDescrizione;
}
