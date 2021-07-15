SELECT
    c.id AS id_cliente,
    c.nombre,
    c.correo,
    c.telefono,
    c.cedula,
    c.id_tarjeta_descuento,
    td.cantidad_reservas
FROM cliente AS c
LEFT JOIN tarjeta_descuento AS td ON c.id_tarjeta_descuento = td.id
where
    c.id = :idCliente
;