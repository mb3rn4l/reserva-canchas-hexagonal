package com.ceiba.cliente.modelo.entidad;

import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {

    public static final String NOMBRE_OBLIGATORIO = "Debe ingresar el nombre";
    public static final String TELEFONO_OBLIGATORIO = "Debe ingresar el telefono";
    public static final String TELEFONO_NUMERICO = "El numero de telefono debe ser numerico";
    public static final String TELEFONO_POSITIVO = "El numero de telefono no puede ser negativo";
    public static final String CEDULA_OBLIGATORIA = "Debe ingresar el numero de cedula";
    public static final String CEDULA_NUMERICO = "El numero de cedula debe ser numerico";
    public static final String CEDULA_POSITIVO = "El numero de cedula no puede ser negativo";
    public static final String TARJETA_DESCUENTO_OBLIGATORIO = "Debe ingresar la tarjeta de descuento";

    private final Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private final String cedula;
    private TarjetaDescuento tarjetaDescuento;

    public Cliente(Long id, String nombre, String correo, String telefono, String cedula, TarjetaDescuento tarjetaDescuento) {
        validarObligatorio(nombre, NOMBRE_OBLIGATORIO);
        validarObligatorio(telefono, TELEFONO_OBLIGATORIO);
        validarNumerico(telefono, TELEFONO_NUMERICO);
        validarPositivo(telefono, TELEFONO_POSITIVO);
        validarObligatorio(cedula, CEDULA_OBLIGATORIA);
        validarNumerico(cedula, CEDULA_NUMERICO);
        validarPositivo(cedula, CEDULA_POSITIVO);
        validarObligatorio(tarjetaDescuento, TARJETA_DESCUENTO_OBLIGATORIO);

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedula = cedula;
        this.tarjetaDescuento = tarjetaDescuento;
    }

    public boolean puedeReclamarDescuento() {
        return this.tarjetaDescuento.puedeAplicarDescuento();
    }
}
