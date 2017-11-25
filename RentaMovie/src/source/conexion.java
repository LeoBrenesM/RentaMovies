package source;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try{
            String sql = "select fnLog('"+username+"','"+password+"') as \"resultado\" from dual";
            rs = st.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("resultado").equals("1")) {
                    bool= true;
                }
            }
            return bool;
        } catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
            return bool;
        }
    }
    
    
    public boolean registrar(String pass, int dia, int mes, int anno,
            String mail, String nombre, int num, String direccion){
        boolean bool = false;
        CallableStatement cs;
        try {
            cs = myDBCon.prepareCall("{call spRegistroV('"+pass+"',TO_DATE('"+dia+"/"+mes+"/"+anno+"','dd/mm/yyyy')," +
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
    public boolean ActualizarC(){
        
    }
}
