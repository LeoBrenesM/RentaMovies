package source;

import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class conexion {
    private Connection myDBCon;
    private Statement st;
    private ResultSet rs;
  
    public void conectarse(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(ClassNotFoundException ex){ 
            System.err.println("Error: " + ex.getMessage());
        }
        try{
            myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","proyecto","1234");
            st = myDBCon.createStatement();
            System.out.println("Conexion Exitosa!");
        } catch(SQLException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
    
    public boolean logear(String username, String password){
        boolean bool = false;
        
        String sql_statement = "{? = call pkVendedor.fnLog('" + username + "','" + password + "')}";
        
        try{
            CallableStatement stmt = myDBCon.prepareCall(sql_statement);
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.execute();
            
            BigDecimal resultado = (BigDecimal)stmt.getObject(1);
            
            String result;
            result = "" + resultado;
            
            if(resultado == null){
                bool = false;
            } else{
                if (result.equals("1")) {
                    bool = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage() +"\n"+ ex.getLocalizedMessage());
            bool = false;
        }
        return bool;
    }
    
    public int id_vendedor(String username){
        int id_vend = 1;
        try{
            String sql = "select id_vendedor from vendedor where email = '" + username + "'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                id_vend = rs.getInt("id_vendedor");
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return id_vend;
    }
    
    public boolean registrar(String pass, int dia, int mes, int anno, String mail, String nombre, int num, String direccion){
        boolean bool = false;
        CallableStatement cs;
        try {
            cs = myDBCon.prepareCall("{call pkVendedor.spRegistroV('"+pass+"',TO_DATE('"+dia+"/"+mes+"/"+anno+"','dd/mm/yyyy')," +
                     "'"+mail+"', '"+nombre+"', "+num+", '"+direccion+"') }");
            cs.execute();
            bool = true;
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        } 
        return bool;
    }
    
    public boolean registrarC(int dia,int mes,int anno,String mail, String nombre, int num, String direccion){
        boolean bool = false;
        CallableStatement cs;
        try {
            cs = myDBCon.prepareCall("{call spRegistroC(TO_DATE('"+dia+"/"+mes+"/"+anno+"','dd/mm/yyyy'),'"+mail+"',"
                    + " '"+direccion+"', "+num+", '"+nombre+"') }");
            cs.execute();
            bool = true;
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage());
        }   
        return bool;
    }
    
    public ArrayList<Cliente> buscarCl(String nombre_buscar){
        ArrayList<Cliente> sClientes = new ArrayList<>();
        
        try{
            String sql = "select id_cliente, nombre_cliente, fecha_nacimiento from Cliente where UPPER(nombre_cliente) like '" +
                    nombre_buscar + "%' order by nombre_cliente";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Cliente sCliente = new Cliente();
                sCliente.setCodigo(rs.getInt("id_cliente"));
                sCliente.setNombre_cliente(rs.getString("nombre_cliente"));
                sCliente.setFecha_nac(rs.getDate("fecha_nacimiento"));
                sClientes.add(sCliente);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sClientes;
    }
    
    public Cliente buscaCliente(int codigo){
        Cliente scliente = new Cliente();
        
        try{
            String sql = "SELECT fecha_nacimiento, nombre_cliente, email, num_telefono, direccion from cliente where id_cliente = " + codigo ;
            rs= st.executeQuery(sql);
            while(rs.next()){
                scliente.setFecha_nac(rs.getDate("fecha_nacimiento"));
                scliente.setNombre_cliente(rs.getString("nombre_cliente"));
                scliente.setEmail(rs.getString("email"));
                scliente.setNum_telefono(rs.getInt("num_telefono"));
                scliente.setDireccion(rs.getString("direccion"));
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return scliente;
    }
    
    public boolean ActualizarC(int codigo, String nombre, int numero, String direccion, String correo){
        boolean boo = false;
        try{
            CallableStatement cs;
            //2, 'mail@mail.com', 'direccion por ahi', 88888888, 'Alejandro'
            cs = myDBCon.prepareCall("{call pkCliente.spActualizarClient(" + codigo + ", '" + correo + "' , '" + direccion +
                                    "', " + numero + ", '" + nombre + "') }");
            cs.execute();
            boo = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return boo;
    }
    
    public boolean RegistrarDir(String nombre){
        boolean boo = false;
        try{
            CallableStatement cs;
            cs = myDBCon.prepareCall("{call pkDirector.spAgregarDirector('" + nombre + "') }");
            cs.execute();
            boo = true;
        } catch(SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return boo;
    }
    public boolean RegistrarCat(String desc){
        boolean boo = false;
        try{
            CallableStatement cs;
            cs = myDBCon.prepareCall("{call pkCategoria.spAgregarCategoria('" + desc + "') }");
            cs.execute();
            boo = true;
        } catch(SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return boo;
    }
    
    public ArrayList<Categoria> llenarCategorias(){
        ArrayList<Categoria> sCategorias = new ArrayList<>();
        try{
            String sql = "select id_categoria, descripcion from categoria order by id_categoria asc";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Categoria iCate = new Categoria();
                iCate.setId(rs.getInt("id_categoria"));
                iCate.setDescripcion(rs.getString("descripcion"));
                sCategorias.add(iCate);
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sCategorias;
    }
    
    public ArrayList<Director> llenarDirectores(){
        ArrayList<Director> sDirectores = new ArrayList<>();
        try{
            String sql = "select id_director, nombre_director from director order by id_director asc";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Director iDirector = new Director();
                iDirector.setId(rs.getInt("id_director"));
                iDirector.setNombre(rs.getString("nombre_director"));
                sDirectores.add(iDirector);
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sDirectores;
    }
    
    public Boolean existePeli(String titulo){
        boolean boo = false;
        String sql_statement = "{? = call pkPelicula.fnexistepelicula('" + titulo + "')}";
        
        try{
            CallableStatement stmt = myDBCon.prepareCall(sql_statement);
            stmt.registerOutParameter(1, OracleTypes.NUMBER);
            stmt.execute();
            
            int resultado = Integer.parseInt(""+stmt.getObject(1));
            
            
            if(resultado == 0){
                boo = true;
            } else{
                JOptionPane.showMessageDialog(null, "La pelicula ya existe!");
            }
        } catch (SQLException ex) {
            System.out.println("error: " + ex.getMessage() +"\n"+ ex.getLocalizedMessage());
            boo = false;
        }
        return boo;
    }
    
    public Boolean registrarPelicula(int id_director, String nombre_peli, int dia,int mes,int anno){
        //spagregarpelicula(id_director in nvarchar2, nombre_peli in nvarchar2, fecha_s in date)
        boolean boo = false;
        if (existePeli(nombre_peli)) {
            try{
                CallableStatement cs;
                cs = myDBCon.prepareCall("{call pkPelicula.spagregarpelicula(" + id_director + ", '" + nombre_peli + "', "
                      + "TO_DATE('" + dia + "/" + mes + "/" + anno + "','dd/mm/yyyy')) }");
                cs.execute();
                boo = true;
            } catch(SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return boo;
    }
    
    public ArrayList<source.Pelicula> buscaPelicula(String nombre){
        ArrayList<source.Pelicula> sPeliculas = new ArrayList<>();
        
        try{
            String sql = "select id_pelicula, nombre_Pelicula from Pelicula where UPPER(nombre_Pelicula) like '" +
                    nombre + "%' order by nombre_Pelicula";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Pelicula iPelicula = new Pelicula();
                iPelicula.setId(rs.getInt("id_pelicula"));
                iPelicula.setNombre_pelicula(rs.getString("nombre_Pelicula"));
                sPeliculas.add(iPelicula);
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sPeliculas;
    }
    
    public Boolean Agregar_Peli_Cate(String nombre_peli, String nombre_cate){
        boolean bool = false;
        try{
            CallableStatement cs;
            cs = myDBCon.prepareCall("{call pkPeli_cate.spagregarpeli_cate('" + nombre_peli + "', '" + nombre_cate + "') }");
            cs.execute();
            bool = true;
        } catch(SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return bool;
    }
    
    public Boolean agregar_formato(String nombre, int precio){
        boolean bool = false;
        try{
            CallableStatement cs;
            cs = myDBCon.prepareCall("{ call pkFormato.sp_agregarFormato('" + nombre + "'," + precio + ") }");
            cs.execute();
            bool = true;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return bool;
    }
    
    public ArrayList<Formato> formatos(){
        ArrayList<Formato> sformatos = new ArrayList<>();
        
        try{
            String sql = "select id_formato, nombre_formato, precio from formato";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Formato iformato = new Formato();
                iformato.setCodigo(rs.getInt("id_formato"));
                iformato.setNombre_formato(rs.getString("nombre_formato"));
                iformato.setPrecio(rs.getInt("precio"));
                sformatos.add(iformato);
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sformatos;
    }
    
    public Boolean actualizar_format(String nombre, int nuevo_precio){
        boolean bool = false;
        try{
            CallableStatement cs = myDBCon.prepareCall("{ call pkFormato.sp_actualizarFormato('" + nombre + "'," + nuevo_precio + ") }");
            cs.execute();
            bool = true;
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return bool;
    }
    
    public boolean ingreso_de_ejemplares(String nombre_peli, String formato, int cantidad_ejemplares){
        boolean boo = false;
        int contador = 0;
        try{
            while(contador < cantidad_ejemplares){
            CallableStatement cs = myDBCon.prepareCall("{ call pkEjemplar.sp_agregar_ejemplar("
                    + "'" + nombre_peli + "','" + formato + "' )}");
            cs.execute();
            boo = true;
            contador++;
            }
        } catch(SQLException ex){
            System.out.println("E r r o r :  " + ex.getMessage());
        }
        
        return boo;
    }
    
    public ArrayList<Ejemplar> busca_Ejemplar(String nombre_pelicula){
        ArrayList<Pelicula> pelis;
        ArrayList<Ejemplar> sEjemplar = new ArrayList<>();
        pelis = buscaPelicula(nombre_pelicula);
        String sql;
        try {
            for(Pelicula peli : pelis){
                sql = "select id_ejemplar, id_formato, id_pelicula from ejemplar where id_pelicula = " + peli.getId();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    Ejemplar ejemp = new Ejemplar();
                    ejemp.setId_ejemplar(rs.getInt("id_ejemplar"));
                    ejemp.setId_formato(rs.getInt("id_formato"));
                    ejemp.setId_pelicula(rs.getInt("id_pelicula"));
                    sEjemplar.add(ejemp);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return sEjemplar;
    }
    public String nombre_peli(int codigo){
        String nombre="";
        ResultSet rs3;
        try{
            nombre ="select nombre_pelicula from pelicula where id_pelicula = " + codigo;
            rs3 = st.executeQuery(nombre);
            while(rs3.next()){
                nombre = rs3.getString("nombre_pelicula");
            }
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return nombre;
    }
    
    public ArrayList<ejemplar_pelicula> busqueda_de_ejemplares_disponibles(String nombre_pelicula){
        ArrayList<ejemplar_pelicula> sEjemps_pelis = new ArrayList<>();
        ArrayList<Ejemplar> iEjemps;
        iEjemps = busca_Ejemplar(nombre_pelicula);
        String sql; int cantidad;
        try{
            for(Ejemplar iejemp : iEjemps){
                sql = "select devuelto from linea where id_ejemplar = " + iejemp.getId_ejemplar();
                rs = st.executeQuery(sql);
                cantidad = 0;
                while(rs.next()){
                    if (rs.getInt("devuelto") == 0) {
                        cantidad += 1;
                    }
                }
                if (cantidad ==0) {
                    ejemplar_pelicula ejemp = new ejemplar_pelicula();
                    ejemp.setCodigo_ejemplar(iejemp.getId_ejemplar());
                    ejemp.setNombre_peli(nombre_peli(iejemp.getId_pelicula()));
                    sEjemps_pelis.add(ejemp);
                }
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sEjemps_pelis;
    }
    
    public Boolean agregarFact(int id_vend, int id_cliente){
        boolean boo = false;
        try{
            CallableStatement cs = myDBCon.prepareCall("{ call pkFactura.sp_agregar_f(" + id_vend + ", " + id_cliente + ")}");
            cs.execute();
            boo = true;
        } catch(SQLException ex){
            System.out.println("E r r o r :  " + ex.getMessage());
        }
        return boo;
    }
    
    public source.Factura ultimaFac(){
        Factura fac = new Factura();
        try{
            String sql = "select max(id_factura) as \"id\" from factura";
            rs = st.executeQuery(sql);
            while(rs.next()){
                fac.setId_factura(rs.getInt("id"));
            }
        }catch (SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return fac;
    }
    
    public Boolean agregarLinea(int id_fac, int id_ejemplar){
        boolean boo = false;
        try{
            CallableStatement cs = myDBCon.prepareCall("{ call pkLinea.sp_agregar_linea(" + id_fac + ", " + id_ejemplar + ")}");
            cs.execute();
            boo = true;
        } catch(SQLException ex){
            System.out.println("E r r o r :  " + ex.getMessage());
        }
        return boo;
    }
    
    public ArrayList<Factura> buscaFacturas(int codigo){
        ArrayList<Factura> sFacturas;
        sFacturas = new ArrayList<>();
        try{
            String sql = "select id_factura, fecha_devolucion, precio_total from factura where id_cliente = " + codigo
                     + " order by fecha_devolucion asc";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Factura iFactura = new Factura();
                iFactura.setId_factura(rs.getInt("id_factura"));
                iFactura.setFecha_devolucion(rs.getDate("fecha_devolucion"));
                iFactura.setTotal(rs.getInt("precio_total"));
                sFacturas.add(iFactura);
            }
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return sFacturas;
    }
    
    public Boolean devuelveFactura(int factura){
        Boolean boo = false;
        try{
            CallableStatement cs = myDBCon.prepareCall("{ call pkFactura.sp_devuelve_f(" + factura + ")}");
            cs.execute();
            boo = true;
        } catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        return boo;
    }
    
}
