package source;

import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import java.lang.Exception;
import java.math.BigDecimal;

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
    
}
