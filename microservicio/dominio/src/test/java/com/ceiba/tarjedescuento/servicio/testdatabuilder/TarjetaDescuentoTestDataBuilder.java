package com.ceiba.tarjedescuento.servicio.testdatabuilder;

import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;

import java.util.UUID;

public class TarjetaDescuentoTestDataBuilder {

    private Long id;
    private int cantidadReservas;

    public TarjetaDescuentoTestDataBuilder() {
        this.id = UUID.randomUUID().getLeastSignificantBits();
        this.cantidadReservas = (int) Math.floor(Math.random()*(4 +1)+ 0);
    }

    public TarjetaDescuentoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TarjetaDescuentoTestDataBuilder conCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
        return this;
    }

    public TarjetaDescuento build() {
        return new TarjetaDescuento(this.id, this.cantidadReservas);
    }
}
