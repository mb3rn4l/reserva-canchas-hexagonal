SELECT
    r.id,
    r.id_cliente,
    r.id_cancha,
    r.fecha AS fecha_reserva,
    r.hora_inicial,
    r.hora_final,
    r.estado,
    r.descuento,
    r.valor_de_pago,
    r.fecha_creacion AS fc_reserva,

    -- valores cancha
    c.descripcion,
    c.id_tipo_cancha,
    c.fecha_creacion  AS fc_cancha,

    -- valores tipo_cancha
    tc.tipo,
    tc.valor_cancha,

    --valores cliente
    cl.nombre,
    cl.correo,
    cl.telefono,
    cl.cedula,
    cl.id_tarjeta_descuento,

    -- valores tarjeta descuento
    td.cantidad_reservas
FROM reserva AS r
LEFT JOIN cancha AS c ON r.id_cancha = c.id
LEFT JOIN tipo_cancha AS tc ON c.id_tipo_cancha = tc.id
LEFT JOIN cliente AS cl ON r.id_cliente = cl.id
LEFT JOIN tarjeta_descuento AS td ON cl.id_tarjeta_descuento = tc.id
;