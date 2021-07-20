package com.ceiba.cancha.controlador;

import com.ceiba.cancha.consulta.manejador.ManejadorListarCanchas;
import com.ceiba.cancha.modelo.dto.DtoCancha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/canchas")
@Api(tags = {"Controlador consulta cancha"})
public class ConsultaControladorCancha {

    private final ManejadorListarCanchas manejadorListarCanchas;

    public ConsultaControladorCancha(ManejadorListarCanchas manejadorListarCanchas) {
        this.manejadorListarCanchas = manejadorListarCanchas;
    }

    @GetMapping
    @ApiOperation("Listar Canchas")
    public List<DtoCancha> listar() {
        return this.manejadorListarCanchas.ejecutar();
    }
}

