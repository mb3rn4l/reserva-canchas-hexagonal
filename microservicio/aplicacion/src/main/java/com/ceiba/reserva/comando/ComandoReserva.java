package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {
    private Long id;
    private Long idCliente;
        private Long idCancha;
        private LocalDate fecha;
        private int horaInicial;
    private String estado;
    private LocalDateTime fechaCreacion;
}
