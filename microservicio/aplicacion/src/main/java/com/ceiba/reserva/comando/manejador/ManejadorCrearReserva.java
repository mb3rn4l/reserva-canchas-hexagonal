package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cancha.puerto.repositorio.RepositorioCancha;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva  implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final FabricaReserva fabricaReserva;
    private final ServicioCrearReserva servicioCrearReserva;
    private final RepositorioCliente repositorioCliente;
    private final RepositorioCancha repositorioCancha;

    public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva,
                                 RepositorioCliente repositorioCliente, RepositorioCancha repositorioCancha ) {
        this.fabricaReserva = fabricaReserva;
        this.servicioCrearReserva = servicioCrearReserva;
        this.repositorioCliente = repositorioCliente;
        this.repositorioCancha = repositorioCancha;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva) {
        Reserva reserva = this.fabricaReserva.crear(comandoReserva, this.repositorioCliente, this.repositorioCancha);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }
}
