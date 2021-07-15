package com.ceiba.cancha.modelo.dto;

import com.ceiba.tipocancha.modelo.dto.DtoTipoCancha;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCancha {
    private Long id;
    private String descripcion;
    private DtoTipoCancha dtoTipoCancha;
    private LocalDateTime fechaCreacion;
}
