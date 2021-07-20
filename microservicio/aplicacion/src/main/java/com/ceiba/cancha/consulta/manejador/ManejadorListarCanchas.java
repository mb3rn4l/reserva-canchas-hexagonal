package com.ceiba.cancha.consulta.manejador;

import com.ceiba.cancha.modelo.dto.DtoCancha;
import com.ceiba.cancha.puerto.dao.DaoCancha;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCanchas {

    private final DaoCancha daoCancha;

    public ManejadorListarCanchas(DaoCancha daoCancha) {
        this.daoCancha = daoCancha;
    }

    public List<DtoCancha> ejecutar() {
        return this.daoCancha.listar();
    }
}
