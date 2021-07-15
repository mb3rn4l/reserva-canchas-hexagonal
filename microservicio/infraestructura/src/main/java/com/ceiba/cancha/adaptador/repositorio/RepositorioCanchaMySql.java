package com.ceiba.cancha.adaptador.repositorio;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cancha.puerto.repositorio.RepositorioCancha;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.adaptador.repositorio.MapeoEntidadReserva;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCanchaMySql  implements RepositorioCancha {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cancha", value="obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioCanchaMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Cancha obtenerPorId(Long idCancha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCancha", idCancha);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlObtenerPorId, paramSource, new MapeoEntidadCancha());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;
        }
    }
}
