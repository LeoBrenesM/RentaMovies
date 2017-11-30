--en el sql plus o sql command line escribe esto:

create user proyecto identified by 1234;
--le da enter
grant all privileges to proyecto;
--le da enter de nuevo y listo, un nuevo usuario donde tener la base de datos del proyecto mas ordenada
create table Cliente(id_cliente number(4), fecha_Nacimiento date, email nvarchar2(30),
                     direccion nvarchar2(150), num_telefono number(10), nombre_Cliente nvarchar2(30) );
alter table Cliente add constraint PKCliente primary key (id_cliente);
alter table Cliente modify (id_cliente number(6));


create table Vendedor(id_vendedor number(4), password nvarchar2(20), fecha_Nacimiento date,
                     email nvarchar2(50), nombre_vendedor nvarchar2(30), numero number(8),
                     direccion nvarchar2(100));
alter table Vendedor add constraint PKVendedor primary key (id_vendedor);

create table Linea(id_factura number(10) primary key, id_ejemplar number(6) primary key );--creela en tables -> create table y con ctrl 
--selecciona el pk en ambas columnas


--esto es secuencia para que se autoincremente el id del vendedor y del cliente tambien;
create sequence s_vendedor
start with 1
increment by 1;

create sequence s_cliente
start with 1
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


--sp para registrar vendedores...
create or replace procedure spRegistroV(pass in nvarchar2, fecha_nac in date, mail in nvarchar2, nombre in nvarchar2,
                                       numero in number, direccion in nvarchar2)
as

begin
  insert into Vendedor values(s_vendedor.nextval, pass, fecha_nac, mail, nombre, numero, direccion);
  commit;
end;
/
execute spRegistroV('12',TO_Date('14/10/1998','dd/mm/yyyy'),'lbrenes@hotmail.com','Leonardo',7,'asdf');
                        
select * from vendedor; 

--procedure para registrar cliente
create or replace procedure spRegistroC(fecha_nac in date, mail in varchar2, direccion in varchar2
                                        , numero in number, nombre in varchar2)
as
begin
  insert into Cliente values(s_cliente.nextval, fecha_nac, mail, direccion, numero, nombre);
  commit;
end;
/

--Stored Procedure para actualizar un cliente
create or replace procedure spActualizarClient(codigo in number, fecha_nac in date, mail in varchar2, direcci in varchar2
                                        , numero in number, nombre in varchar2)
as
begin
    update Cliente set fecha_nacimiento = fecha_nac, email = mail, direccion = direcci, num_telefono = numero, nombre_cliente = nombre
    where id_cliente = codigo;
    commit;
end;
/

select * from cliente;


