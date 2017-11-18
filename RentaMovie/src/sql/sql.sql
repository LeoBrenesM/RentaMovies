--en el sql plus o sql command line escribe esto: 
--create user proyecto identified by 1234;
--le da enter
grant all privileges to proyecto;
--le da enter de nuevo y listo, un nuevo usuario donde tener nuestras bases de datos hahaha
create table Cliente(id_cliente number(4), fecha_Nacimiento date, email nvarchar2(30),
                     direccion nvarchar2(150), num_telefono number(10), nombre_Cliente nvarchar2(30) );

alter table Cliente add constraint PKCliente primary key (id_cliente);


insert into Cliente values(1, TO_DATE('1998/10/14','yyyy/mm/dd'),'lbrenes10@hotmail.com',
                             'Costa Rica, San Jose, Goicoechea, Guadalupe...', 85572537, 'Leonardo Brenes' );


select * from Cliente;


create table Vendedor(id_vendedor number(4), password nvarchar2(20), fecha_Nacimiento date,
                     email nvarchar2(50), nombre_vendedor nvarchar2(30), numero number(8),
                     direccion nvarchar2(100));

insert into Vendedor values(1, '1234', TO_DATE('1998/10/14','yyyy/mm/dd'), 'lbrenes1098@gmail.com',
                     'Leonardo', 85572537, 'Costa Rica, San Jose, Goicoechea, Guadalupe...'  );

select * from Vendedor;


--funcion para el login...
create or replace function fnLog(username in nvarchar2, pass in nvarchar2)
return number
as
  resultado number:=0;
  contraU nvarchar2(20);
begin
  select password into contraU from vendedor where username = email;
  if contraU = pass then
    resultado :=1;
  else resultado :=0;
  end if;
  return resultado;
end;
/
/*
--funcion o sp para registrar vendedores...
create or replace procedure spRegistroV(pass in nvarchar2, fecha_nac in date, mail in nvarchar2, nombre in nvarchar2,
                                       numero in number, direccion in nvarchar2)
as
  cant number;
begin
  select fnCant into cant from dual;
  insert into Vendedor values(cant+1, pass, fecha_nac, mail, nombre, numero, direccion);
  commit;
end;
/
*/