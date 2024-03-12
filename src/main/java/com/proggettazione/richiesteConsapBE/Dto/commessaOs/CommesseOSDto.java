package com.proggettazione.richiesteConsapBE.Dto.commessaOs;


import com.proggettazione.richiesteConsapBE.Dto.ErroreDto;
import lombok.Data;

import java.util.List;

@Data
public class CommesseOSDto {
    private ErroreDto erroreDto;
    private CommessaOSFiltro commessaOSFiltro;
    private List<CommessaOSDto> commessaOSDtoList;
}
