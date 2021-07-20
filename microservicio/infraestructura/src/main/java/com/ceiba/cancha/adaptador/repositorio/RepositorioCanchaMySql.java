package com.ceiba.cancha.adaptador.repositorio;

import com.ceiba.cancha.modelo.entidad.Cancha;
import com.ceiba.cancha.puerto.repositorio.RepositorioCancha;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.adaptador.repositorio.RepositorioReservaMysql;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioCanchaMySql implements RepositorioCancha {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado.";
    private static final Logger LOGGER = Logger.getLogger(RepositorioReservaMysql.class.getName());

    @SqlStatement(namespace = "cancha", value = "obtenerPorId")
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
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }
}
