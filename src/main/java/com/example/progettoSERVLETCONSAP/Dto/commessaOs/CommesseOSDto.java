package com.example.progettoSERVLETCONSAP.Dto.commessaOs;



import com.example.progettoSERVLETCONSAP.Dto.ErroreDto;
import lombok.Data;

import java.util.List;

@Data
public class CommesseOSDto {
    private ErroreDto erroreDto;
    private CommessaOSFiltro commessaOSFiltro;
    private List<CommessaOSDto> commessaOSDtoList;
}
