insert into usuario(nombre, clave, fecha_creacion) values ('test', '1234', now());

insert into tipo_cancha(tipo, valor_cancha) values ('FUTBOL 5', 80000);

insert into cancha(descripcion, id_tipo_cancha, fecha_creacion) values ('CANCHA 1', 1, now());

insert into tarjeta_descuento(cantidad_reservas) values (0);

insert into cliente(nombre, correo, telefono, cedula, id_tarjeta_descuento) values ('PEPITO PEREZ', 'pepito@prueba.com', '3211012233', '1116548745', 1);

insert into reserva(id_cliente, id_cancha, fecha, hora_inicial, hora_final, estado, descuento, valor_de_pago, fecha_creacion) values (1, 1, now(), 20, 21, 'REGISTRADA', 0, 80000, now());

