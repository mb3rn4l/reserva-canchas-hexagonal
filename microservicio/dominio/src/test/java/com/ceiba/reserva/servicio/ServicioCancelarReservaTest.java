package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.estado.modelo.entidad.Estado;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCancelarReservaTest {

    @Test
    public void cancelarReserva() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conEstado(Estado.REGISTRADA.toString()).build();
        reserva.cancelar();

        // act - assert
        Assert.assertEquals(Estado.CANCELADA, reserva.getEstado());
    }

    @Test
    public void noSePuedeCancelarReservaYaCancelada() {
        Reserva reserva = new ReservaTestDataBuilder().conEstado(Estado.CANCELADA.toString()).build();

        // act - assert
        BasePrueba.assertThrows(
                () -> reserva.cancelar(),
                ExcepcionValorInvalido.class,
                "Reserva ya esta cancelada");
    }

    @Test
    public void cancelarReservaNoExistente() {
        // arrange
        Long idReserva = 100L;
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.obtenerPorId(Mockito.anyLong())).thenReturn(null);
        ServicioCancelarReserva servicioCancelarReserva = new ServicioCancelarReserva(repositorioReserva);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCancelarReserva.ejecutar(idReserva),
                ExcepcionSinDatos.class,
                "La reserva no existe en el sistema");
    }
}
