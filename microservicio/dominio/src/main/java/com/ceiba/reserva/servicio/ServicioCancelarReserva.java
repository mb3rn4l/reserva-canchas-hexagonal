package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioCancelarReserva {

    private static final String RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";
    private final RepositorioReserva repositorioReserva;

    public ServicioCancelarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long idReserva) {
        Reserva reserva = obtenerReserva(idReserva);
        reserva.cancelar();
        this.repositorioReserva.actualizar(reserva);
    }

    public Reserva obtenerReserva(Long idReserva) {
        Reserva reserva = this.repositorioReserva.obtenerPorId(idReserva);

        if (reserva == null) throw new RuntimeException(RESERVA_NO_EXISTE_EN_EL_SISTEMA);

        return reserva;
    }
}
