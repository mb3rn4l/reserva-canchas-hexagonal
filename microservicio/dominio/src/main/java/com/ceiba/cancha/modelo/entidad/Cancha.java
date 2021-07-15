package com.ceiba.cancha.modelo.entidad;

import com.ceiba.tipocancha.modelo.entidad.TipoCancha;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cancha {

    private static final String DESCRIPCION_OBLIGATORIA = "Debe ingresar la descripción";
    private static final String TIPO_CANCA_OBLIGATORIO = "Debe ingresar el tipo de cancha";

    private Long id;
    private String descripcion;
    private TipoCancha tipoCancha;
    private LocalDateTime fechaCreacion;

    public Cancha(Long id, String descripcion, TipoCancha tipoCancha, LocalDateTime fechaCreacion) {
        validarObligatorio(descripcion, DESCRIPCION_OBLIGATORIA);
        validarObligatorio(tipoCancha, TIPO_CANCA_OBLIGATORIO);

        this.id = id;
        this.descripcion = descripcion;
        this.tipoCancha = tipoCancha;
        this.fechaCreacion = fechaCreacion;
    }

    public double obtenerValorDeLaCancha(){
        return this.tipoCancha.getValorCancha();
    }
}
