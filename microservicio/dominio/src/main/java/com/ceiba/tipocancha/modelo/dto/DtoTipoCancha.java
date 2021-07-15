package com.ceiba.tipocancha.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoCancha {
    private Long id;
    private String tipo;
    private double valorCancha;
}
