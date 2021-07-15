update reserva
set
    id_cliente = :idCliente,
    id_cancha = :idCancha,
    fecha = :fecha,
    hora_inicial = :horaInicial,
    hora_final = :horaFinal,
    estado = :estado,
    descuento = :descuento,
    valor_de_pago = :valorDePago,
    fecha_creacion = :fechaCreacion
where id = :id
;