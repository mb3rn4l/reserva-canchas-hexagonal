package com.ceiba.reserva.adaptador.dao;

import com.ceiba.cancha.modelo.dto.DtoCancha;
import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.tarjetadescuento.modelo.dto.DtoTarjetaDescuento;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import com.ceiba.tipocancha.modelo.dto.DtoTipoCancha;
import com.ceiba.tipocancha.modelo.entidad.TipoCancha;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoDaoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idTarjetaDescuento = resultSet.getLong("id_tarjeta_descuento");
        int cantidad_reservas = resultSet.getInt("cantidad_reservas");
        DtoTarjetaDescuento tarjetaDescuento = new DtoTarjetaDescuento(idTarjetaDescuento, cantidad_reservas);

        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        String correo = resultSet.getString("correo");
        String telefono = resultSet.getString("telefono");
        String cedula = resultSet.getString("cedula");
        DtoCliente cliente = new DtoCliente(idCliente, nombre, correo, telefono, cedula, tarjetaDescuento);

        Long idTipoCancha = resultSet.getLong("id_tipo_cancha");
        String tipo = resultSet.getString("tipo");
        double valorCancha = resultSet.getDouble("valor_cancha");
        DtoTipoCancha tipoCancha = new DtoTipoCancha(idTipoCancha, tipo, valorCancha);

        Long idCancha = resultSet.getLong("id_cancha");
        String descripcion = resultSet.getString("descripcion");
        LocalDateTime fechaCreacionCancha = extraerLocalDateTime(resultSet, "fc_cancha");
        DtoCancha cancha = new DtoCancha(idCancha, descripcion, tipoCancha, fechaCreacionCancha);

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
