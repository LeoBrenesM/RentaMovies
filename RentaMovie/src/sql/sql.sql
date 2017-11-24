--en el sql plus o sql command line escribe esto: 
create user proyecto identified by 1234;
--le da enter
grant all privileges to proyecto;
--le da enter de nuevo y listo, un nuevo usuario donde tener la base de datos del proyecto hahaha
create table Cliente(id_cliente number(4), fecha_Nacimiento date, email nvarchar2(30),
                     direccion nvarchar2(150), num_telefono number(10), nombre_Cliente nvarchar2(30) );
alter table Cliente add constraint PKCliente primary key (id_cliente);

create table Vendedor(id_vendedor number(4), password nvarchar2(20), fecha_Nacimiento date,
                     email nvarchar2(50), nombre_vendedor nvarchar2(30), numero number(8),
                     direccion nvarchar2(100));
alter table Vendedor add constraint PKVendedor primary key (id_vendedor);

create table Linea(id_factura number(10) primary key, id_ejemplar number(6) primary key );

--esto es secuencia para que se autoincremente el id del vendedor y del cliente tambien;
create sequence s_vendedor
start with 1
increment by 1;

create sequence s_cliente
start with 0
increment by 1;

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


--funcion o sp para registrar vendedores...
create or replace procedure spRegistroV(pass in nvarchar2, fecha_nac in date, mail in nvarchar2, nombre in nvarchar2,
                                       numero in number, direccion in nvarchar2)
as
  cant number;
begin
  select fnCant into cant from dual;
  insert into Vendedor values(s_vendedor.nextval, pass, fecha_nac, mail, nombre, numero, direccion);
  commit;
end;
/

insert into Vendedor values(s_vendedor.nextval, '1234', to_date('1997/12/18','yyyy/mm/dd'),
                           'ngaritaconstante@hotmail.com', 'Tatiana', 85572537, 
                           'De la Plaza de Deportes de la Pitahaya, 25 metros norte, quinta casa a mano izquierda');
                           
