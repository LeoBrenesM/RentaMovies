package source;

import java.sql.*;

public class conexion {
    private Connection myDBCon;
    private Statement st;
    private ResultSet rs;
  
    public void conectarse(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception ex){ 
            System.err.println("Error: " + ex.getMessage());
        }
        try{
            myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","proyecto","1234");
            st = myDBCon.createStatement();
            System.out.println("Conexion Exitosa!");
        } catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
    public boolean logear(String username, String password){
        boolean bool = false;
        try{
            String sql = "select email, password from Vendedor";
            rs = st.executeQuery(sql);
            while(rs.next()){
                if (rs.getString("email").equals(username) && rs.getString("password").equals(password)) {
                    bool= true;
                }
            }
            return bool;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return bool;
        }
    }
    
    public ResultSet getData(){
        try{
            String query = "select * from vendedor";
            rs = st.executeQuery(query);
            return rs;
        } catch(Exception e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
    
}
