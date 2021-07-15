package com.ceiba.descuento.modelo.entidad;

public enum TiposDescuento implements Descuento{
    SIN_DESCUENTO(0),
    DESCUENTO_POR_HORA(10),
    DESCUENTO_POR_CANCHAS(35)
    ;

    private final double porcentaje;

    TiposDescuento(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double tarifa) {
        return  tarifa * (this.porcentaje / 100);
    }
}
