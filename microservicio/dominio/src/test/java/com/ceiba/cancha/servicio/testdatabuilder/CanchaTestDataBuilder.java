package com.ceiba.cancha.servicio.testdatabuilder;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.tipocancha.modelo.entidad.TipoCancha;
import com.ceiba.tipocancha.servicio.testdatabuilder.TipoCanchaTestDataBuilder;

import java.time.LocalDateTime;

public class CanchaTestDataBuilder {

    private static final String DESCRIPCION_CANCHA = "cancha 1";

    private Long id;
    private String descripcion;
    private TipoCancha tipoCancha;
    private LocalDateTime fechaCreacion;

    public CanchaTestDataBuilder() {

        TipoCancha tipoCancha = new TipoCanchaTestDataBuilder().build();

        this.descripcion = DESCRIPCION_CANCHA;
        this.tipoCancha = tipoCancha;
        this.fechaCreacion = LocalDateTime.now();

    }

    public CanchaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CanchaTestDataBuilder conTipoCancha(TipoCancha tipoCancha) {
        this.tipoCancha = tipoCancha;
        return this;
    }

    public Cancha build() {
        return new Cancha(this.id, this.descripcion, this.tipoCancha, this.fechaCreacion);
    }
}
