package com.ceiba.reserva.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.estado.modelo.entidad.Estado;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCancelarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
//import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador comando reserva"})
public class ComandoControladorReserva {
    private final ManejadorCrearReserva manejadorCrearReserva;
    // private final ManejadorEliminarReserva manejadorEliminarReserva;
    private final ManejadorCancelarReserva manejadorCancelarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva,
//                                     ManejadorEliminarReserva manejadorEliminarReserva,
                                     ManejadorCancelarReserva manejadorCancelarReserva
                                     ) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        //this.manejadorEliminarReserva = manejadorEliminarReserva;
        this.manejadorCancelarReserva = manejadorCancelarReserva;
    }

    @PostMapping
    @ApiOperation("Crear Reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        comandoReserva.setEstado(Estado.REGISTRADA.toString());
        comandoReserva.setFechaCreacion(LocalDateTime.now());
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @PatchMapping(value="/cancelar/{id}")
    @ApiOperation("Cancelar Reserva")
    public void cancelar(@PathVariable Long id) {
        manejadorCancelarReserva.ejecutar(id);
    }

}
