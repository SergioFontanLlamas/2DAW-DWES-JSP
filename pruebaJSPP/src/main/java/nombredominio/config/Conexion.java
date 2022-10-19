/**
 * 
 */
package nombredominio.config;

import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
        
    }
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoJSP","root","");            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public Connection desconectar() {
        con = null;
        return con;
    }
    public Connection getConnection(){
        return con;
    }
}
