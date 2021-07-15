package com.ceiba.cliente.adaptador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoEntidadCliente implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idTarjetaDescuento = resultSet.getLong("id_tarjeta_descuento");
        int cantidadReservas = resultSet.getInt("cantidad_reservas");
        TarjetaDescuento tarjetaDescuento = new TarjetaDescuento(idTarjetaDescuento, cantidadReservas);

        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        String correo = resultSet.getString("correo");
        String telefono = resultSet.getString("telefono");
        String cedula = resultSet.getString("cedula");

        return new Cliente(idCliente, nombre, correo, telefono, cedula, tarjetaDescuento);
    }
}