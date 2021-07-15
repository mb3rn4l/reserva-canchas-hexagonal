package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.estado.modelo.entidad.Estado;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import com.ceiba.tarjedescuento.servicio.testdatabuilder.TarjetaDescuentoTestDataBuilder;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {

    private double calcularDescuento(double porcentajeDescuento, double valorCancha){
        return valorCancha * (porcentajeDescuento / 100);
    }

    private double calcularValorDePago(double valorCancha, double descuento){
        return valorCancha - descuento;
    }

    @Test
    public void reservaDebeDurarUnaHora() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder();
        int horaInicial = 16;
        Reserva reserva = reservaTestDataBuilder.conHoraInicial(horaInicial).build();
        int horaFinal = horaInicial + 1;

        // act - assert
        Assert.assertEquals(reserva.getHoraFinal(), horaFinal);
    }
    
    
    @Test
    public void validarHoraFueraDeRangoDisponible(){
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conHoraInicial(11);

        // act - assert
        BasePrueba.assertThrows(
                () -> reservaTestDataBuilder.build(),
                ExcepcionValorInvalido.class,
                "La reserva debe ser entre las 4 PM y las 10 PM");
    }

    
    @Test
    public void reservaSinDescuento() {
        // arrange
        int horaInicial = 20;
        double valorCancha = 80000;
        int porcentajeDescuento = 0;
        double descuento = this.calcularDescuento(porcentajeDescuento, valorCancha);
        double valorDePago = this.calcularValorDePago(valorCancha, descuento);
        Reserva reserva = new ReservaTestDataBuilder().conHoraInicial(horaInicial).build();

        // act - assert
        Assert.assertEquals(reserva.getDescuento(), descuento, 0.0);
        Assert.assertEquals(reserva.getValorDePago(), valorDePago, 0.0);
    }

    
    @Test
    public void reservaConDescuentoPorHora() {
        // arrange
        int horaInicial = 16;
        double valorCancha = 80000;
        int porcentajeDescuento = 10;
        double descuento = this.calcularDescuento(porcentajeDescuento, valorCancha);
        double valorDePago = this.calcularValorDePago(valorCancha, descuento);
        Reserva reserva = new ReservaTestDataBuilder().conHoraInicial(horaInicial).build();

        // act - assert
        Assert.assertEquals(reserva.getDescuento(), descuento, 0.0);
        Assert.assertEquals(reserva.getValorDePago(), valorDePago, 0.0);
    }

    
    @Test
    public void reservaConDescuentoPorCanchas() {
        // arrange
        TarjetaDescuento tarjetaDescuento = new TarjetaDescuentoTestDataBuilder().conCantidadReservas(5).build();
        Cliente cliente = new ClienteTestDataBuilder().conTarjetaDescuento(tarjetaDescuento).build();
        double valorCancha = 80000;
        int porcentajeDescuento = 35;
        double descuento = this.calcularDescuento(porcentajeDescuento, valorCancha);
        double valorDePago = this.calcularValorDePago(valorCancha, descuento);
        Reserva reserva = new ReservaTestDataBuilder().conCliente(cliente).build();

        // act - assert
        Assert.assertEquals(reserva.getDescuento(), descuento, 0.0);
        Assert.assertEquals(reserva.getValorDePago(), valorDePago, 0.0);
    }
   

    @Test
    public void horarioNoDisponible() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(
                repositorioReserva.existe(
                        Mockito.anyLong(),
                        Mockito.anyObject(),
                        Mockito.anyInt(),
                        Mockito.anyInt())
        ).thenReturn(true);

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearReserva.ejecutar(reserva),
                ExcepcionDuplicidad.class,
                "La reserva ya existe en el sistema");
    }
    
}
