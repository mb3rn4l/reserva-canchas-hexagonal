package com.ceiba.cancha.adaptador.dao;

import com.ceiba.cancha.modelo.dto.DtoCancha;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoDaoCancha implements RowMapper<DtoCancha>, MapperResult {

    @Override
    public DtoCancha mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idCancha = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion");

        return new DtoCancha(idCancha, descripcion);
    }
}