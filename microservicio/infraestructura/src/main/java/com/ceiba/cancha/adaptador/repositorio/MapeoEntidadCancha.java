package com.ceiba.cancha.adaptador.repositorio;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipocancha.modelo.entidad.TipoCancha;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class MapeoEntidadCancha implements RowMapper<Cancha>, MapperResult {

    @Override
    public Cancha mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idTipoCancha = resultSet.getLong("id_tipo_cancha");
        String tipo = resultSet.getString("tipo");
        double valorCancha = resultSet.getDouble("valor_cancha");
        TipoCancha tipoCancha = new TipoCancha(idTipoCancha, tipo, valorCancha);

        Long idCancha = resultSet.getLong("id_cancha");
        String descripcion = resultSet.getString("descripcion");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new Cancha(idCancha, descripcion, tipoCancha, fechaCreacion);
    }
}