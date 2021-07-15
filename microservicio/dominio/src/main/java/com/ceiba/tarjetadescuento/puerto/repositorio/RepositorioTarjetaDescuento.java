package com.ceiba.tarjetadescuento.puerto.repositorio;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;

public interface RepositorioTarjetaDescuento {

    TarjetaDescuento obtenerTarjetaDescuentoPorUsuario(Long idUsuaio);

    // boolean usuarioTieneCincoReservas(Long idUsuario);
    // Long actualizar(TarjetaDescuento tarjetaDescuento);
}
