package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.time.LocalDate;
import java.util.List;

public interface DaoReserva {

    List<DtoReserva> listar(LocalDate fecha);
}
