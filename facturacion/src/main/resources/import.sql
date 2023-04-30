-- Tabla clientes

insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Leonardo','Aviles','A1234','patito','5545678912','leo@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Carlos','Alvarez','B1234','patito','7889451623','carlos@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Juan','Arreola','C1234','patito','7891255456','juan@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Martin','Velazquez','D1234','patito','6789125545','martin@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Miguel','Mendez','E1234','patito','5545678912','miguel@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('David','Gonzalez','F1234','patito','5545627891','david@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Raul','Arreola','G1234','patito','8912554567','raul@gmail.com');
insert into clients (nombre,apellido,dni,direccion,telefono,correo) values ('Oscar','Marquez','H1234','patito','5589124567','oscar@gmail.com');

-- tabla productis

insert into products (nombre,codigo,stock,precio) values ('Carne','123',10,150);
insert into products (nombre,codigo,stock,precio) values ('Lata','1234',10,150);
insert into products (nombre,codigo,stock,precio) values ('Sabritas','12345',10,150);
insert into products (nombre,codigo,stock,precio) values ('Mayonessa','123456',10,150);
insert into products (nombre,codigo,stock,precio) values ('Crema','1234567',10,150);
insert into products (nombre,codigo,stock,precio) values ('Pan','12345678',10,150);
insert into products (nombre,codigo,stock,precio) values ('Harina','123456789',10,150);

--tabla facturacion

insert into factura (date_factura,fk_cliente, fk_producto) values ('04/03/2023',1,1);
insert into factura (date_factura,fk_cliente, fk_producto) values ('05/04/2022',2,2);



