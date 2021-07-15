package com.ceiba.tipocancha.puerto.repositorio;

import com.ceiba.tarjetadescuento.modelo.entidad.TarjetaDescuento;
import com.ceiba.tipocancha.modelo.entidad.TipoCancha;

public interface RepositorioTipoCancha {

    TipoCancha obtenerTipoCanchaPorId(Long idTipoCancha);

}
