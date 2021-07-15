package com.ceiba.tipocancha.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class TipoCancha {
    private static final String DESCRIPCION_OBLIGATORIA = "Debe ingresar la descripción";
    private static final String VALOR_CANCHA_OBLIGATORIO = "Debe ingresar el valor de la cancha";
    private static final String VALOR_CANCHA_POSITIVO = "El valor de la cancha debe ser mayor a cero";

    private Long id;
    private String tipo;
    private double valorCancha;


    public TipoCancha(Long id, String tipo, Double valorCancha) {
        validarObligatorio(tipo, DESCRIPCION_OBLIGATORIA);
        validarObligatorio(valorCancha, VALOR_CANCHA_OBLIGATORIO);
        validarPositivo(valorCancha, VALOR_CANCHA_POSITIVO);

        this.id = id;
        this.tipo = tipo;
        this.valorCancha = valorCancha;
    }
}
