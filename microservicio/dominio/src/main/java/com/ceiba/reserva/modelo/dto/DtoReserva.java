package com.ceiba.reserva.modelo.dto;

import com.ceiba.cancha.modelo.dto.DtoCancha;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private DtoCliente cliente;
    private DtoCancha cancha;
    private LocalDate fecha;
    private int horaInicial;
    private int horaFinal;
    private String estado;
    private double descuento;
    private double valorDePago;
    private LocalDateTime fechaCreacion;
}
