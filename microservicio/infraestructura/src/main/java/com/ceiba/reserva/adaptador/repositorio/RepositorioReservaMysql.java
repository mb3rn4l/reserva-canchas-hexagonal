package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="reserva", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="reserva", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="reserva", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="reserva", value="obtenerPorId")
    private static String sqlObtenerPorId;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosReserva(Reserva reserva) {
        return new MapSqlParameterSource()
                .addValue("id", reserva.getId())
                .addValue("idCliente", reserva.getCliente().getId())
                .addValue("idCancha", reserva.getCancha().getId())
                .addValue("fecha", reserva.getFecha())
                .addValue("horaInicial", reserva.getHoraInicial())
                .addValue("horaFinal", reserva.getHoraFinal())
                .addValue("estado", reserva.getEstado().toString())
                .addValue("descuento", reserva.getDescuento())
                .addValue("valorDePago", reserva.getValorDePago())
                .addValue("fechaCreacion", reserva.getFechaCreacion());
    }


    @Override
    public Long crear(Reserva reserva) {
        SqlParameterSource parameterSource = this.obtenerParametrosReserva(reserva);
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
        //return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void actualizar(Reserva reserva) {
        SqlParameterSource parameterSource = this.obtenerParametrosReserva(reserva);
        this.customNamedParameterJdbcTemplate.actualizar(parameterSource, sqlActualizar);
        //this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long idCancha, LocalDate fecha, int horaInicial, int horaFinal) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCancha", idCancha);
        paramSource.addValue("fecha", fecha);
        paramSource.addValue("horaInicial", horaInicial);
        paramSource.addValue("horaFinal", horaFinal);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().
                queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public Reserva obtenerPorId(Long idReserva) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idReserva", idReserva);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                    .queryForObject(sqlObtenerPorId, paramSource, new MapeoEntidadReserva());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;

        }
    }
}
