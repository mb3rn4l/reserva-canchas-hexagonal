create table  usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table tarjeta_descuento(
 id int(11) not null auto_increment,
 cantidad_reservas int (2) not null,
 primary key (id)
);

create table  cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 correo varchar(100) not null,
 telefono varchar(100) not null,
 cedula varchar(100) not null unique,
 id_tarjeta_descuento int(11) not null,
 primary key (id),
 foreign key (id_tarjeta_descuento) references tarjeta_descuento(id)
);

create table tipo_cancha(
 id int(11) not null auto_increment,
 tipo varchar(100) not null,
 valor_cancha double not null,
 primary key (id)
);

create table cancha (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 id_tipo_cancha  int(11) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table tipo_descuento (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null unique,
 valor double not null,
 primary key (id)
);

create table  reserva (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 id_cancha int(11) not null,
 fecha date not null,
 hora_inicial int(2) not null,
 hora_final int(2) not null,
 estado varchar(100) check (estado in ('REGISTRADA', 'CANCELADA')),
 descuento double not null,
 valor_de_pago double not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 primary key (id),
 foreign key (id_cliente) references cliente(id),
 foreign key (id_cancha) references cancha(id)
);


insert into usuario(nombre, clave, fecha_creacion) values ('test', '1234', now());

insert into tipo_cancha(tipo, valor_cancha) values ('FUTBOL 5', 80000);

insert into cancha(descripcion, id_tipo_cancha, fecha_creacion) values ('CANCHA 1', 1, now());

insert into tarjeta_descuento(cantidad_reservas) values (0);

insert into cliente(nombre, correo, telefono, cedula, id_tarjeta_descuento) values ('PEPITO PEREZ', 'pepito@prueba.com', '3211012233', '1116548745', 1);

insert into reserva(id_cliente, id_cancha, fecha, hora_inicial, hora_final, estado, descuento, valor_de_pago, fecha_creacion) values (1, 1, now(), 20, 21, 'REGISTRADA', 0, 80000, now());

