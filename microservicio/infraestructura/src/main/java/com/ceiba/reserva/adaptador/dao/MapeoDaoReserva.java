package com.ceiba.reserva.adaptador.dao;

import com.ceiba.cancha.modelo.dto.DtoCancha;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoDaoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        DtoCliente cliente = new DtoCliente(idCliente, nombre);


        Long idCancha = resultSet.getLong("id_cancha");
        String descripcion = resultSet.getString("descripcion");
        DtoCancha cancha = new DtoCancha(idCancha, descripcion);

        Long id = resultSet.getLong("id");
        LocalDate fecha = extraerLocalDate(resultSet, "fecha_reserva");
        int horaInicial = resultSet.getInt("hora_inicial");
        int horaFinal = resultSet.getInt("hora_final");
        String estado = resultSet.getString("estado");
        double descuento = resultSet.getDouble("descuento");
        double valorDepago = resultSet.getDouble("valor_de_pago");
        LocalDateTime fechaCreacionReserva = extraerLocalDateTime(resultSet, "fc_reserva");

        return new DtoReserva(id, cliente, cancha, fecha, horaInicial, horaFinal, estado, descuento, valorDepago, fechaCreacionReserva);
    }

}
