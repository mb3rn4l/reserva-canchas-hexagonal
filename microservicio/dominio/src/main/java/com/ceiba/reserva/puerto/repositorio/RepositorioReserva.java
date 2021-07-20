package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;


public interface RepositorioReserva {

    Long crear(Reserva reserva);

    void actualizar(Reserva reserva);

    void eliminar(Long id);

    /**
     * Permite validar si existe una reserva para esa cancha en esa fecha en ese rango horario
     */
    boolean existe(Long idCancha, LocalDate fecha, int horaInicial, int horaFinal);

    Reserva obtenerPorId(Long idReserva);
}
