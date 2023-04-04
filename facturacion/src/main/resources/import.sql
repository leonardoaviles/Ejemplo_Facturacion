-- Tabla clientes

insert into clients (nombre,apellido,direccion,telefono,correo) values ('Leonardo','Aviles','patito','5545678912','leo@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Carlos','Alvarez','patito','7889451623','carlos@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Juan','Arreola','patito','7891255456','juan@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Martin','Velazquez','patito','6789125545','martin@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Miguel','Mendez','patito','5545678912','miguel@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('David','Gonzalez','patito','5545627891','david@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Raul','Arreola','patito','8912554567','raul@gmail.com');
insert into clients (nombre,apellido,direccion,telefono,correo) values ('Oscar','Marquez','patito','5589124567','oscar@gmail.com');

-- tabla productis

insert into products (nombre,stock,precio) values ('Carne',10,150);
insert into products (nombre,stock,precio) values ('Lata',10,150);
insert into products (nombre,stock,precio) values ('Sabritas',10,150);
insert into products (nombre,stock,precio) values ('Mayonessa',10,150);
insert into products (nombre,stock,precio) values ('Crema',10,150);
insert into products (nombre,stock,precio) values ('Pan',10,150);
insert into products (nombre,stock,precio) values ('Harina',10,150);

--tabla facturacion

insert into factura (date_factura,fk_cliente, fk_producto) values ('04/03/2023',1,1);
insert into factura (date_factura,fk_cliente, fk_producto) values ('05/04/2022',2,2);



