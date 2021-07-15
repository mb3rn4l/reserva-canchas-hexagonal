package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.tarjedescuento.servicio.testdatabuilder.TarjetaDescuentoTestDataBuilder;
import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;

public class ClienteTestDataBuilder {

    private static final String NOMBRE_CLIENTE = "pepito perez";
    private static final String CEDULA_CLIENTE = "1116548745";
    private static final String CORREO_CLIENTE = "pepito@prueba.com";
    private static final String TELEFONO_CLIENTE = "3211012233";

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String cedula;
    private TarjetaDescuento tarjetaDescuento;

    public ClienteTestDataBuilder() {

        TarjetaDescuento tarjetaDescuento = new TarjetaDescuentoTestDataBuilder().build();

        this.nombre = NOMBRE_CLIENTE;
        this.correo = CORREO_CLIENTE;
        this.telefono = TELEFONO_CLIENTE;
        this.cedula = CEDULA_CLIENTE;
        this.tarjetaDescuento = tarjetaDescuento;
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conTarjetaDescuento(TarjetaDescuento tarjetaDescuento) {
        this.tarjetaDescuento = tarjetaDescuento;
        return this;
    }

    public Cliente build() {
        return new Cliente(this.id, this.nombre, this.correo, this.telefono, this.cedula, this.tarjetaDescuento);
    }
}
