select count(1) from reserva
where id_cancha = :idCancha
and fecha = :fecha
and hora_inicial >= :horaInicial
and hora_final <= :horaFinal
;