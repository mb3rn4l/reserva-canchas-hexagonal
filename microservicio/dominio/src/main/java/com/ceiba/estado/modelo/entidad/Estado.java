package com.ceiba.estado.modelo.entidad;

public enum Estado implements EstadoReserva {
    REGISTRADA {
        @Override
        public Estado cancelar() {
            return Estado.CANCELADA;
        }
    },
    CANCELADA {
        @Override
        public Estado cancelar() {
            throw new RuntimeException("Reserva ya esta cancelada");
        }
    };
}
