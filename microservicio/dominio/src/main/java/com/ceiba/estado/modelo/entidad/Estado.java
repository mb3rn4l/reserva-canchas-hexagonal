package com.ceiba.estado.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

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
            throw new ExcepcionValorInvalido("Reserva ya esta cancelada");
        }
    };
}
