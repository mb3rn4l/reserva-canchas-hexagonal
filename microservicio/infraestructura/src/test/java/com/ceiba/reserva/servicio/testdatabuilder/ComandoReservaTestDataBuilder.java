package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idCancha;
    private LocalDate fecha;
    private int horaInicial;
    private String estado;
    private LocalDateTime fechaCreacion;

    public ComandoReservaTestDataBuilder() {
        idUsuario = UUID.randomUUID().getLeastSignificantBits();
        idCancha = UUID.randomUUID().getLeastSignificantBits();
        fecha = LocalDate.now();
        horaInicial = (int) Math.floor(Math.random()*(22 -16+1)+16);
        fechaCreacion = LocalDateTime.now();
    }

    public ComandoReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoReservaTestDataBuilder conHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
        return this;
    }

    public ComandoReservaTestDataBuilder conEstado(String estado){
        this.estado = estado;
        return this;
    }
    
    public ComandoReservaTestDataBuilder conUsuario(Long idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }
    
    public ComandoReservaTestDataBuilder conCancha(Long idCancha){
        this.idCancha = idCancha;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(this.id, this.idUsuario, this.idCancha, this.fecha, this.horaInicial, this.estado, this.fechaCreacion);
    }
}
