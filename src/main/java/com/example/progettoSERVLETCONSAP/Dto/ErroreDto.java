package com.example.progettoSERVLETCONSAP.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErroreDto {

    private int erroreId;
    private String descrizioneErrore;
    private String messaggioErrore;
}
