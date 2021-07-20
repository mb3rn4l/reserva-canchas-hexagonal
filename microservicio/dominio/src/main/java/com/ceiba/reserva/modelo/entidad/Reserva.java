package com.ceiba.reserva.modelo.entidad;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.descuento.modelo.entidad.TiposDescuento;
import com.ceiba.estado.modelo.entidad.Estado;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;


@Getter
public class Reserva {

    private static final String USUARIO_OBLIGATORIO = "Debe ingresar un usuario valido";
    private static final String CANCHA_OBLIGATORIA = "Debe ingresar una cancha valida";
    private static final String FECHA_OBLIGATORIA = "Debe ingresar la fecha";
    private static final String FECHA_MENOR = "La fecha debe ser mayor o igual a hoy";
    private static final String HORA_INICIAL_OBLIGATORIA = "Debe ingresar la hora inicial";
    private static final String ESTADO_OBLIGATORIO = "Debe ingresar el estado";
    private static final String ESTADO_NO_PERMITIDO = "Ingrese un estado valido";
    private static final String HORA_FUERA_DE_RANGO = "La reserva debe ser entre las 4 PM y las 10 PM";

    private static final int HORA_MINIMA_RESERVA = 16;
    private static final int HORA_MAXIMA_RESERVA = 22;
    private static final int HORA_MAXIMA_DESCUENTO_RESERVA = 19;

    private Long id;
    private Cliente cliente;
    private Cancha cancha;
    private LocalDate fecha;
    private int horaInicial;
    private int horaFinal;
    private Estado estado;
    private double descuento;
    private double valorDePago;
    private LocalDateTime fechaCreacion;


    public Reserva(Long id, Cliente cliente, Cancha cancha, LocalDate fecha, int horaInicial, String estado,
                   LocalDateTime fechaCreacion) {

        validarObligatorio(cliente, USUARIO_OBLIGATORIO);
        validarObligatorio(cancha, CANCHA_OBLIGATORIA);
        validarObligatorio(fecha, FECHA_OBLIGATORIA);
        validarObligatorio(horaInicial, HORA_INICIAL_OBLIGATORIA);
        validarObligatorio(estado, ESTADO_OBLIGATORIO);
        validarMenor(horaInicial, HORA_MAXIMA_RESERVA, HORA_FUERA_DE_RANGO);
        validarMenor(HORA_MINIMA_RESERVA, horaInicial, HORA_FUERA_DE_RANGO);
        validarMenor(LocalDate.now(), fecha, FECHA_MENOR);

        this.estado = validarValido(estado, Estado.class, ESTADO_NO_PERMITIDO);

        this.id = id;
        this.cliente = cliente;
        this.cancha = cancha;
        this.fecha = fecha;
        this.horaInicial = horaInicial;
        this.calcularHoraFinalizacion();
        this.obtenerInformacionDePago();
        this.fechaCreacion = fechaCreacion;
    }

    private void obtenerInformacionDePago() {

        double valorCancha = this.obtenerValorDeLaCancha();
        TiposDescuento tipoDescuento = this.obtenerTipoDescuento();
        this.descuento = tipoDescuento.calcularDescuento(valorCancha);
        this.valorDePago = valorCancha - descuento;
    }

    private double obtenerValorDeLaCancha() {
        return this.cancha.obtenerValorDeLaCancha();
    }

    private TiposDescuento obtenerTipoDescuento() {

        TiposDescuento tipoDescuento = TiposDescuento.SIN_DESCUENTO;

        if (this.puedeAplicarDescuentoPorHora())
            tipoDescuento = TiposDescuento.DESCUENTO_POR_HORA;

        if (this.puedeAplicarDescuentoCancha())
            tipoDescuento = TiposDescuento.DESCUENTO_POR_CANCHAS;

        return tipoDescuento;
    }

    private boolean puedeAplicarDescuentoCancha() {
        return this.cliente.puedeReclamarDescuento();
    }

    private void calcularHoraFinalizacion() {
        this.horaFinal = this.horaInicial + 1;
    }

    private boolean puedeAplicarDescuentoPorHora() {
        return this.horaInicial <= HORA_MAXIMA_DESCUENTO_RESERVA;
    }

    public void cancelar() {
        this.estado = this.estado.cancelar();
    }
}
