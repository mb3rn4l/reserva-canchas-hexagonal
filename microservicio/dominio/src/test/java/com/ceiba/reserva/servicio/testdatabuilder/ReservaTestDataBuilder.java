package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cancha.servicio.testdatabuilder.CanchaTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.estado.modelo.entidad.Estado;
import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

    private Long id;
    private Cliente cliente;
    private Cancha cancha;
    private LocalDate fecha;
    private int horaInicial;
    private String estado;
    private LocalDateTime fechaCreacion;

    public ReservaTestDataBuilder() {

        Cliente cliente = new ClienteTestDataBuilder().build();
        Cancha cancha = new CanchaTestDataBuilder().build();

        this.cliente = cliente;
        this.cancha = cancha;
        this.fecha = LocalDate.now();
        this.horaInicial = (int) Math.floor(Math.random() * (22 - 16 + 1) + 16);
        this.estado = Estado.REGISTRADA.toString();
        this.fechaCreacion = LocalDateTime.now();

    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
        return this;
    }

    public ReservaTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public ReservaTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ReservaTestDataBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public Reserva build() {
        return new Reserva(this.id, this.cliente, this.cancha, this.fecha, this.horaInicial, this.estado, this.fechaCreacion);
    }
}
