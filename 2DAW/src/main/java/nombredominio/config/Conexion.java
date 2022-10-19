/**
 * 
 */
package nombredominio.config;

import java.sql.*;

/**
 * @author sergio
 *
 */
public class Conexion {
	Connection conection;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyecto2daw", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return conection;
	}
	
	public Connection desconectar() {
		conection = null;
		return conection;
	}

}
