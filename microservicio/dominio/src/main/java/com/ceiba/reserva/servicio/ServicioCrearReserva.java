package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;


public class ServicioCrearReserva {
    private static final String RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";

    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva){
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva){
        validarDisponibilidad(reserva);
        return this.repositorioReserva.crear(reserva);
    }


    private void validarDisponibilidad(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getCancha().getId(), reserva.getFecha(),
                reserva.getHoraInicial(),
                reserva.getHoraFinal());

        if(existe) {
            throw new ExcepcionDuplicidad(RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
