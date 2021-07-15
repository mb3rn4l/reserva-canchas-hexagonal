package com.ceiba.tarjetadescuento.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarMenor;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TarjetaDescuento {
    private static final String  CANTIDAD_OBLIGATORIO = "Debe ingresar la descripción";
    private static final String CANTIDAD_MAYOR = "La cantidad de reservas no puede ser mayor a ";
    private static final String CANTIDAD_MENOR = "La cantidad de reservas no puede ser menor a ";

    private static final int CANTIDAD_MINIMA = 0;
    private static final int CANTIDAD_MAXIMA = 5;

    private Long id;
    private int cantidadReservas;

    public TarjetaDescuento(Long id, Integer cantidadReservas) {
        validarObligatorio(cantidadReservas, CANTIDAD_OBLIGATORIO);
        validarMenor(cantidadReservas, CANTIDAD_MAXIMA, CANTIDAD_MAYOR + CANTIDAD_MAXIMA);
        validarMenor(CANTIDAD_MINIMA, cantidadReservas, CANTIDAD_MENOR + CANTIDAD_MINIMA);
        this.id = id;
        this.cantidadReservas = cantidadReservas;
    }

    public void aumentarCantidadReservas(){
        this.cantidadReservas ++;
    }

    public void disminuirCantidadReservas(){
        this.cantidadReservas --;
    }

    public boolean puedeAplicarDescuento(){
        return this.cantidadReservas >= CANTIDAD_MAXIMA;
    }

}
