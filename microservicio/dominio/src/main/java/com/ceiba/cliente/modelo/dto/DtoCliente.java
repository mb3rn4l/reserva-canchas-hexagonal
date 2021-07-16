package com.ceiba.cliente.modelo.dto;

import com.ceiba.tarjetadescuento.modelo.dto.DtoTarjetaDescuento;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCliente {
    private final Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private final String cedula;
    private DtoTarjetaDescuento dtoTarjetaDescuento;
}
