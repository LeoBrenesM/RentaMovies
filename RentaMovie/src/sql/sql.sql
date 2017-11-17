/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lbren
 * Created: Nov 16, 2017
 */

--en el sql plus o sql command line escribe esto: 
create user proyecto identified by 1234;
--le da enter
grant all privileges to proyecto;
--le da enter de nuevo y listo, un nuevo usuario donde tener nuestras bases de datos hahaha
create table Cliente(id_cliente number(4), fecha_Nacimiento date, email nvarchar2(30),
                     direccion nvarchar2(150), num_telefono number(10), nombre_Cliente nvarchar2(30) );

alter table Cliente add constraint PKCliente primary key (id_cliente);


insert into Cliente values(1, TO_DATE('1998/10/14','yyyy/mm/dd'),'lbrenes10@hotmail.com',
 'Costa Rica, San Jose, Goicoechea, Guadalupe...', 85572537, 'Leonardo Brenes' );

select * from Cliente;