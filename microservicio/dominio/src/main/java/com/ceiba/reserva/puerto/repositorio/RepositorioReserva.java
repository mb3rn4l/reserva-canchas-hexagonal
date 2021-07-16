package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;


public interface RepositorioReserva {

    /**
     * Permite crear una reserva
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param reserva
     * @return el id generado
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar una reserva
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una reserva para esa cancha en esa fecha en ese rango horario
     * @param idCancha
     * @param horaInicial
     * @param horaFinal
     * @return si existe o no
     */
    boolean existe(Long idCancha, LocalDate fecha,  int horaInicial, int horaFinal);

    Reserva obtenerPorId(Long idReserva);
}
