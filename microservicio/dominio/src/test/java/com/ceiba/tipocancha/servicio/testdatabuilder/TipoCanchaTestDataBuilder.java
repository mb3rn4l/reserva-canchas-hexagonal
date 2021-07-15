package com.ceiba.tipocancha.servicio.testdatabuilder;

import com.ceiba.tipocancha.modelo.entidad.TipoCancha;

import java.util.UUID;

public class TipoCanchaTestDataBuilder {

    private static final String  TIPO_FUTBOL_5 = "futbol 5";
    private static final double VALOR_CANCHA = 80000;

    private Long id;
    private String tipo;
    private double valorCancha;

    public TipoCanchaTestDataBuilder() {
        id = UUID.randomUUID().getLeastSignificantBits();
        this.tipo =  TIPO_FUTBOL_5;
        valorCancha = VALOR_CANCHA;
    }

    public TipoCanchaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TipoCanchaTestDataBuilder conValor(double valorCancha) {
        this.valorCancha = valorCancha;
        return this;
    }

    public TipoCancha build() {
        return new TipoCancha(this.id, tipo, valorCancha);
    }
}
