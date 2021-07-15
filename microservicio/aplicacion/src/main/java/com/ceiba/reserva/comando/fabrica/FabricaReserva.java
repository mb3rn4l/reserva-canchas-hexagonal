package com.ceiba.reserva.comando.fabrica;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cancha.puerto.repositorio.RepositorioCancha;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.modelo.entidad.*;
import org.springframework.stereotype.Component;


@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva, RepositorioCliente repositorioCliente,
                         RepositorioCancha repositorioCancha){

        Cliente cliente = repositorioCliente.obtenerPorId(comandoReserva.getIdCliente());
        Cancha cancha = repositorioCancha.obtenerPorId(comandoReserva.getIdCancha());

        return new Reserva(comandoReserva.getId(),
                cliente,
                cancha,
                comandoReserva.getFecha(),
                comandoReserva.getHoraInicial(),
                comandoReserva.getEstado(),
                comandoReserva.getFechaCreacion()
        );
    }
}
