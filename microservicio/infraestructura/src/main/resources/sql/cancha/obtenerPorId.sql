SELECT
    c.id AS id_cancha,
    c.descripcion,
    c.id_tipo_cancha,
    c.fecha_creacion,
    tc.tipo,
    tc.valor_cancha
FROM cancha AS c
LEFT JOIN tipo_cancha AS tc ON c.id_tipo_cancha = tc.id
where
    c.id = :idCancha
;