package com.ceiba.reserva.adaptador.repositorio;


import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import com.ceiba.tipocancha.modelo.entidad.TipoCancha;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoEntidadReserva implements RowMapper<Reserva>, MapperResult {

    @Override
    public Reserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idTarjetaDescuento = resultSet.getLong("id_tarjeta_descuento");
        int cantidadReservas = resultSet.getInt("cantidad_reservas");
        TarjetaDescuento tarjetaDescuento = new TarjetaDescuento(idTarjetaDescuento, cantidadReservas);

        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        String correo = resultSet.getString("correo");
        String telefono = resultSet.getString("telefono");
        String cedula = resultSet.getString("cedula");
        Cliente cliente = new Cliente(idCliente, nombre, correo, telefono, cedula, tarjetaDescuento);

        Long idTipoCancha = resultSet.getLong("id_tipo_cancha");
        String tipo = resultSet.getString("tipo");
        double valorCancha = resultSet.getDouble("valor_cancha");
        TipoCancha tipoCancha = new TipoCancha(idTipoCancha, tipo, valorCancha);

        Long idCancha = resultSet.getLong("id_cancha");
        String descripcion = resultSet.getString("descripcion");
        LocalDateTime fechaCreacionCancha = extraerLocalDateTime(resultSet, "fc_cancha");
        Cancha cancha = new Cancha(idCancha, descripcion, tipoCancha, fechaCreacionCancha);

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha_reserva");
        int horaInicial = resultSet.getInt("hora_inicial");
        String estado = resultSet.getString("estado");
        LocalDateTime fechaCreacionReserva = extraerLocalDateTime(resultSet, "fc_reserva");

        return new Reserva(id, cliente, cancha, fecha, horaInicial, estado, fechaCreacionReserva);
    }
}