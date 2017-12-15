    --en el sql plus o sql command line escribe esto:

CREATE USER proyecto IDENTIFIED BY 1234;
--le da enter
GRANT ALL PRIVILEGES TO proyecto;
--le da enter de nuevo y listo, un nuevo usuario donde tener la base de datos del proyecto mas ordenada
CREATE TABLE cliente(id_cliente NUMBER(4), fecha_nacimiento DATE, email NVARCHAR2(30),
                     direccion NVARCHAR2(150), num_telefono NUMBER(10), nombre_cliente NVARCHAR2(30) );
ALTER TABLE cliente ADD CONSTRAINT pkcliente PRIMARY KEY (id_cliente);
ALTER TABLE cliente MODIFY (id_cliente NUMBER(6));


CREATE TABLE vendedor(id_vendedor NUMBER(4), PASSWORD NVARCHAR2(20), fecha_nacimiento DATE,
                     email NVARCHAR2(50), nombre_vendedor NVARCHAR2(30), numero NUMBER(8),
                     direccion NVARCHAR2(100));
ALTER TABLE vendedor ADD CONSTRAINT pkvendedor PRIMARY KEY (id_vendedor);

CREATE TABLE linea(id_factura NUMBER(10) PRIMARY KEY, id_ejemplar NUMBER(6) PRIMARY KEY );--creela en tables -> create table y con ctrl 
--selecciona el pk en ambas columnas

CREATE TABLE ejemplar(id_ejemplar NUMBER(6), id_formato NUMBER(2), id_pelicula NUMBER(8));
ALTER TABLE ejemplar ADD CONSTRAINT pkejemplar PRIMARY KEY (id_ejemplar);
ALTER TABLE ejemplar ADD FOREIGN KEY (id_formato) REFERENCES formato (id_formato);
ALTER TABLE ejemplar ADD FOREIGN KEY (id_pelicula) REFERENCES pelicula (id_pelicula);

CREATE TABLE formato(id_formato NUMBER(2), nombre_formato VARCHAR2(10), precio NUMBER(6));
ALTER TABLE formato ADD CONSTRAINT pkformato PRIMARY KEY (id_formato);
ALTER TABLE formato MODIFY id_formato NOT NULL;
ALTER TABLE formato MODIFY nombre_formato NOT NULL;
ALTER TABLE formato MODIFY precio NOT NULL;


CREATE TABLE director(id_director NUMBER(4) PRIMARY KEY NOT NULL, nombre_director VARCHAR2(40) NOT NULL);

CREATE TABLE pelicula(id_pelicula NUMBER(8) PRIMARY KEY NOT NULL, id_director NUMBER(4),
                      nombre_pelicula VARCHAR2(50), fecha_salida DATE,
                      CONSTRAINT fk_peli_direct FOREIGN KEY (id_director) REFERENCES director (id_director));

CREATE TABLE pelicula_categoria(id_pelicula NUMBER(8), id_categoria NUMBER(2));--esto lo hace a pura interfaz para que sea la llave compuesta.

CREATE TABLE categoria (id_categoria NUMBER(2) PRIMARY KEY NOT NULL, descripcion VARCHAR2(20) NOT NULL);

CREATE TABLE auditoria (id_vendedor NUMBER(4), origen VARCHAR2(20) NOT NULL, fecha DATE NOT NULL,
                        descripcion VARCHAR2(300) NOT NULL, error_generado VARCHAR2(100));
ALTER TABLE auditoria MODIFY id_vendedor NOT NULL;
ALTER TABLE auditoria ADD FOREIGN KEY (id_vendedor) REFERENCES vendedor (id_vendedor);


-- ? eso era solo de la creacion de las tablas!

--esto es secuencia para que se autoincremente el id del vendedor y del cliente tambien;

                                /*        --        PAQUETES        --        */

--package de vendedor

CREATE SEQUENCE s_vendedor
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PACKAGE pkvendedor IS 

    FUNCTION fnlog (username IN NVARCHAR2, pass IN NVARCHAR2) RETURN NUMBER;
    
    PROCEDURE spregistrov(pass IN NVARCHAR2, fecha_nac IN DATE, mail IN NVARCHAR2, nombre IN NVARCHAR2,
                                       numero IN NUMBER, direccion IN NVARCHAR2);
    FUNCTION fn_existe_vendedor(correo in varchar2)
    return number;
END;


CREATE OR REPLACE PACKAGE BODY pkvendedor IS

    FUNCTION fnlog(username IN NVARCHAR2, pass IN NVARCHAR2)
    RETURN NUMBER
    AS
        resultado NUMBER := 0;
        contrau NVARCHAR2(20):='';
        cant NUMBER;
        VMES VARCHAR2(500);
        NERROR NUMBER;
        usuario varchar2(8);
    BEGIN
      SELECT COUNT(id_vendedor) INTO cant FROM vendedor WHERE username = email;
      IF cant > 0 THEN
        SELECT PASSWORD INTO contrau FROM vendedor WHERE username = email;
        IF contrau = pass THEN
          resultado := 1;
        ELSE 
          resultado := 0;
        END IF;
      ELSE
        resultado :=0;
      END IF;
    RETURN resultado;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' VENDEDOR', sysdate, vmes, nerror );
    END;
    
    PROCEDURE spregistrov(pass IN NVARCHAR2, fecha_nac IN DATE, mail IN NVARCHAR2, nombre IN NVARCHAR2,
                                       numero IN NUMBER, direccion IN NVARCHAR2)
    AS
        VMES VARCHAR2(500);
        NERROR NUMBER;
        usuario varchar2(8);
    BEGIN
        INSERT INTO vendedor VALUES(s_vendedor.NEXTVAL, pass, fecha_nac, mail, nombre, numero, direccion);
        COMMIT;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' VENDEDOR ', sysdate, vmes, nerror );
    END;
    
    FUNCTION fn_existe_vendedor(correo in varchar2)
    return number
    as
      respuesta number;
      VMES VARCHAR2(500);
      NERROR NUMBER;
      usuario varchar2(8);
    begin
      select count(id_vendedor) into respuesta from vendedor where email = correo;
      if respuesta = 0 then
        select id_vendedor into respuesta from vendedor where email = correo;
      end if;
      return respuesta;
      EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' VENDEDOR ', sysdate, vmes, nerror );
    end;
END;


-- Package del cliente

CREATE SEQUENCE s_cliente
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PACKAGE pkcliente IS
    PROCEDURE spregistroc(fecha_nac IN DATE, mail IN VARCHAR2, direccion IN VARCHAR2
                                        , numero IN NUMBER, nombre IN VARCHAR2);
    
    PROCEDURE spactualizarclient(codigo IN NUMBER, mail IN VARCHAR2, direcci IN VARCHAR2
                                        , numero IN NUMBER, nombre IN VARCHAR2);

END;

CREATE OR REPLACE PACKAGE BODY pkcliente IS
    PROCEDURE spregistroc(fecha_nac IN DATE, mail IN VARCHAR2, direccion IN VARCHAR2
                                        , numero IN NUMBER, nombre IN VARCHAR2)
    AS
      VMES VARCHAR2(500);
      NERROR NUMBER;
      usuario varchar2(8);
    BEGIN
        INSERT INTO cliente VALUES(s_cliente.NEXTVAL, fecha_nac, mail, direccion, numero, nombre);
        COMMIT;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' CLIENTE ', sysdate, vmes, nerror );
    END;
    
    PROCEDURE spactualizarclient(codigo IN NUMBER, mail IN VARCHAR2, direcci IN VARCHAR2
                                        , numero IN NUMBER, nombre IN VARCHAR2)
    AS
      VMES VARCHAR2(500);
      NERROR NUMBER;
      usuario varchar2(8);
    BEGIN
        UPDATE cliente SET email = mail, direccion = direcci, num_telefono = numero, nombre_cliente = nombre
        WHERE id_cliente = codigo;
        COMMIT;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' CLIENTE ', sysdate, vmes, nerror );
    END;
END;

-- PACKAGE de director

CREATE SEQUENCE s_director
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PACKAGE pkdirector IS
    PROCEDURE spagregardirector(nombre IN NVARCHAR2);
    
    FUNCTION fnexistedirector(nombre IN VARCHAR2)
    RETURN NUMBER;
END;

CREATE OR REPLACE PACKAGE BODY pkdirector IS
  
  PROCEDURE spagregardirector(nombre IN NVARCHAR2)
  AS
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    INSERT INTO director VALUES(s_director.NEXTVAL, nombre);
    COMMIT;
  EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' DIRECTOR ', sysdate, vmes, nerror );
  END;

  FUNCTION fnexistedirector(nombre IN VARCHAR2)
    RETURN NUMBER
  AS
    codigo NUMBER:=0;
    cant NUMBER:=0;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    SELECT COUNT(id_director) INTO cant FROM director WHERE nombre_director = nombre;
    IF cant > 0 THEN
      SELECT id_director INTO codigo FROM director WHERE nombre_director = nombre;
    ELSE
      codigo:= 0;
    END IF;
    RETURN codigo;
  EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' CATEGORIA ', sysdate, vmes, nerror );
  END;
END;

--categoria
CREATE SEQUENCE s_categoria
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PACKAGE pkcategoria IS
    PROCEDURE spagregarcategoria(descrip IN NVARCHAR2);
    
    FUNCTION fnexistecategoria(descrip IN VARCHAR2)
    RETURN NUMBER;
END;

CREATE OR REPLACE PACKAGE BODY pkcategoria IS
  
  PROCEDURE spagregarcategoria(descrip IN NVARCHAR2)
  AS
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    INSERT INTO categoria VALUES(s_categoria.NEXTVAL, descrip);
    COMMIT;
  EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' CATEGORIA ', sysdate, vmes, nerror );
  END;

  FUNCTION fnexistecategoria(descrip IN VARCHAR2)
    RETURN NUMBER
  AS
    codigo NUMBER:=0;
    cant NUMBER:=0;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    SELECT COUNT(id_categoria) INTO cant FROM categoria WHERE descripcion = descrip;
    IF cant > 0 THEN
      SELECT id_categoria INTO codigo FROM categoria WHERE descripcion = descrip;
    ELSE
      codigo:= 0;
    END IF;
    RETURN codigo;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' CATEGORIA ', sysdate, vmes, nerror );
  END;
END;


-- peliculas 

CREATE SEQUENCE s_pelicula
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE PACKAGE pkpelicula IS
    PROCEDURE spagregarpelicula(id_director in nvarchar2, nombre_peli in nvarchar2, fecha_s in date);
    
    FUNCTION fnexistepelicula(nombre_peli IN VARCHAR2)
    RETURN NUMBER;
END;

CREATE OR REPLACE PACKAGE BODY pkpelicula IS
  
  PROCEDURE spagregarpelicula(id_director in nvarchar2, nombre_peli in nvarchar2, fecha_s in date)
  AS
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    INSERT INTO pelicula VALUES(s_pelicula.NEXTVAL, id_director, nombre_peli, fecha_s);
    COMMIT;
  EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' PELICULA ', sysdate, vmes, nerror );
  END;

  FUNCTION fnexistepelicula(nombre_peli IN VARCHAR2)
    RETURN NUMBER
  AS
    codigo NUMBER:=0;
    cant NUMBER:=0;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    SELECT COUNT(id_pelicula) INTO cant FROM pelicula WHERE UPPER(nombre_pelicula) = UPPER(nombre_peli);
    IF cant > 0 THEN
      SELECT id_pelicula INTO codigo FROM pelicula WHERE UPPER(nombre_pelicula) = UPPER(nombre_peli);
    ELSE
      codigo:= 0;
    END IF;
    RETURN codigo;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' PELICULA ', sysdate, vmes, nerror );
  END;
END;


--PELICULA POR CATEGORIA

CREATE OR REPLACE PACKAGE pkpeli_cate IS
    PROCEDURE spagregarpeli_cate(nombre_peli in nvarchar2, desc_categoria in varchar2);
    
    FUNCTION fnexistepeli_cate(id_peli in number, id_cate in number)
    RETURN NUMBER;
END;


CREATE OR REPLACE PACKAGE BODY pkpeli_cate IS
  
  PROCEDURE spagregarpeli_cate(nombre_peli in nvarchar2, desc_categoria in varchar2)
  AS
    existe_peli number(8);
    existe_cate number(2);
    existe_peli_cate number(10);
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    select pkpelicula.fnexistepelicula(nombre_peli) into existe_peli from dual;
    select pkcategoria.fnexisteCategoria(desc_categoria) into existe_cate from dual;
    IF existe_peli > 0 THEN
      IF existe_cate > 0 THEN
        select pkpeli_cate.fnexistepeli_cate(existe_peli, existe_cate) into existe_peli_cate from dual;
        IF existe_peli_cate = 0 then
          INSERT INTO pelicula_categoria VALUES(existe_peli, existe_cate);
          COMMIT;
        end if;
      END IF;
    END IF;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' PELICULA POR CATEGORIA ', sysdate, vmes, nerror );
  END;

  FUNCTION fnexistepeli_cate(id_peli in number, id_cate in number)
    RETURN NUMBER
  AS
    codigo NUMBER:=0;
    cant NUMBER:=0;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    SELECT COUNT(id_pelicula) INTO cant FROM pelicula_categoria WHERE id_pelicula = id_peli AND id_categoria = id_cate;
    IF cant > 0 THEN
      SELECT id_pelicula || id_categoria INTO codigo FROM pelicula_categoria WHERE id_pelicula = id_peli AND id_categoria = id_cate;
    ELSE
      codigo:= 0;
    END IF;
    RETURN codigo;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' PELICULA POR CATEGORIA ', sysdate, vmes, nerror );
  END;
END;

--FORMATO

create sequence s_formato
start with 1
increment by 1;

CREATE OR REPLACE PACKAGE PKFORMATO IS
  PROCEDURE sp_agregarFormato(nombre in varchar2, precio in number);
  FUNCTION fn_existe_Formato(nombre varchar2)
    RETURN NUMBER;
  PROCEDURE sp_actualizarFormato(nombre in varchar2, vprecio in number);
END;

CREATE OR REPLACE PACKAGE BODY PKFORMATO IS
  PROCEDURE sp_agregarFormato(nombre in varchar2, precio in number)
  as
    existe_formato number;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  begin
    select fn_existe_formato(nombre) into existe_formato from dual;
    if existe_formato = 0 then
      INSERT INTO FORMATO VALUES(s_formato.nextval, nombre, precio);
      COMMIT;
    end if;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' FORMATO ', sysdate, vmes, nerror );
  end;
  
  FUNCTION fn_existe_Formato(nombre in varchar2)
  RETURN NUMBER
  AS
    codigo NUMBER:=0;
    cant NUMBER:=0;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    SELECT COUNT(id_formato) INTO cant FROM formato WHERE nombre_formato = nombre;
    IF cant > 0 THEN
      SELECT id_formato INTO codigo FROM formato WHERE nombre_formato = nombre;
    ELSE
      codigo:= 0;
    END IF;
    RETURN codigo;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' FORMATO ', sysdate, vmes, nerror );
  end;

  PROCEDURE sp_actualizarFormato(nombre in varchar2, vprecio in number)
  as
    existe_formato number;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  begin
    select fn_existe_formato(nombre) into existe_formato from dual;
    if existe_formato > 0 then
      UPDATE formato set precio = vprecio where nombre_formato = nombre;
      COMMIT;
    end if;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' FORMATO ', sysdate, vmes, nerror );
  end;
END;



--EJEMPLAR

CREATE SEQUENCE s_ejemplar
start with 1
increment by 1;

CREATE OR REPLACE PACKAGE pkEjemplar IS
  PROCEDURE sp_agregar_Ejemplar(peli in varchar2, formato in varchar2);
END;

CREATE OR REPLACE PACKAGE BODY pkEjemplar IS

  PROCEDURE sp_agregar_Ejemplar(peli in varchar2, formato in varchar2)
  as
    existe_peli number;
    existe_formato number;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  begin
    select pkpelicula.fnexistepelicula(peli) into existe_peli from dual;
    select pkformato.fn_existe_formato(formato) into existe_formato from dual;
    if existe_peli > 0 then
      if existe_formato > 0 then
        insert into ejemplar values(s_ejemplar.nextval, existe_formato, existe_peli);
        commit;
      end if;
    end if;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' EJEMPLAR ', sysdate, vmes, nerror );
  end;

END;

--FACTURA
CREATE SEQUENCE s_factura
start with 1
increment by 1;

CREATE OR REPLACE PACKAGE pkFactura IS
  PROCEDURE sp_agregar_f(id_vendedor IN number, id_cliente IN NUMBER);
  PROCEDURE sp_lineas(datos out sys_refcursor, id_fac in number);
  PROCEDURE sp_devuelve_f(id_fac in number);
END;

CREATE OR REPLACE PACKAGE BODY pkFactura IS
  
  PROCEDURE sp_agregar_f(id_vendedor IN number, id_cliente IN NUMBER)
  AS
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  BEGIN
    IF id_vendedor > 0 THEN 
      IF to_char(sysdate + 3, 'day') = 'SUNDAY' THEN
        INSERT INTO factura VALUES(s_factura.NEXTVAL, id_cliente, id_vendedor, sysdate, 0, sysdate + 4);
      ELSE
        INSERT INTO factura VALUES(s_factura.NEXTVAL, id_cliente, id_vendedor, sysdate, 0, sysdate + 3);
      END IF;   
    END IF;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' FACTURA ', sysdate, vmes, nerror );
  END;
  
  
  PROCEDURE sp_lineas(datos out sys_refcursor, id_fac in number) --esto lo agregue para usar sql dinamico y sys_refcursor..
  as
  vsql varchar2(300);
  begin
  vsql := 'select id_factura, id_ejemplar from linea where id_factura = :id_fac';
    open datos for vsql using id_fac;
  end;
  
  PROCEDURE sp_devuelve_f(id_fac in number)  --por consiguiente aqui hice cambios....
  as
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
    datosb sys_refcursor;
    vid_factura number;
    id_ejem number;
  begin
    pkfactura.sp_lineas(datosb, id_fac);
    LOOP
      FETCH datosb into vid_factura, id_ejem;
      EXIT WHEN datosb%notfound;
        update linea set devuelto = 1 where id_factura = vid_factura and id_ejemplar = id_ejem;
    END LOOP;
    commit;
  EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' FACTURA ', sysdate, vmes, nerror );
  end;
  
END;

--LINEA
CREATE OR REPLACE PACKAGE PKLINEA IS
    PROCEDURE sp_agregar_linea(id_fac in number, id_ejem in number);
END;

CREATE OR REPLACE PACKAGE BODY PKLINEA IS
  PROCEDURE sp_agregar_linea(id_fac in number, id_ejem in number)
  as
    existe_factura number;
    monto_agregar number;
    VMES VARCHAR2(500);
    NERROR NUMBER;
    usuario varchar2(8);
  begin
    select count(id_factura) into existe_factura from factura where id_factura = id_fac;
    if existe_factura > 0 then
      insert into linea values(id_fac, id_ejem, 0);
      select f.precio into monto_agregar from formato f 
      inner join ejemplar e on f.id_formato = e.id_formato
      where e.id_ejemplar = id_ejem;
      update factura set precio_total = (precio_total + monto_agregar) where id_factura = id_fac;
      commit;
    end if;
    EXCEPTION
      WHEN OTHERS THEN
        NERROR := SQLCODE;
        VMES := SQLERRM;
        select user into usuario from dual;
        insert into auditoria values(usuario, ' LINEA ', sysdate, vmes, nerror );
  end;
  
END;


-- triggers
  -- PARA REGISTRAR LOS UPDATES E INSERTS EN LA TABLA HISTORICO
create or replace TRIGGER tgr_formato
  AFTER UPDATE OR INSERT ON FORMATO
  FOR EACH ROW
BEGIN
  if UPDATING THEN
    insert into historico values(sysdate, 'FORMATO', :OLD.id_formato, ' update ', :old.precio, :new.precio);
  else 
    insert into historico values(sysdate, 'FORMATO', :new.id_formato, ' insert ', :new.precio, :new.precio);
  end if;
end;


select * from pelicula;