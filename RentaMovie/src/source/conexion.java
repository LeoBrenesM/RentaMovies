package source;

import java.sql.*;
/**
 *
 * @author lbren
 */

public class conexion {
    private Connection myDBCon;
    private Statement st;
    private ResultSet rs;
  
    public conexion(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
        try{
            myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            st = myDBCon.createStatement();
            System.out.println("Conexion Exitosa.");
        } catch(Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
  }
}
