package com.ceiba.estado.modelo.entidad;

import com.ceiba.reserva.modelo.entidad.Reserva;

public enum Estado implements EstadoReserva {
    REGISTRADA{
        @Override
        public Estado cancelar() {
            return Estado.CANCELADA;
        }
    },
    CANCELADA{
        @Override
        public Estado cancelar() {
            throw new RuntimeException("Reserva ya esta cancelada");
        }
    }
    ;
}
