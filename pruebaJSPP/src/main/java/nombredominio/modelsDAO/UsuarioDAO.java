/**
 * 
 */
package nombredominio.modelsDAO;

import nombredominio.config.*;
import nombredominio.interfaces.*;
import nombredominio.models.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author sergio
 *
 */
public class UsuarioDAO implements Crud{
	Conexion cn = new Conexion();
	
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario usuario = new Usuario();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
	@Override
	public ArrayList<Usuario> all() {
	    cn.conectar();
        String sql="SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            usuarios = new ArrayList<>();
            
            while(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("Id"));
                user.setNombre(rs.getString("Nombre"));
                user.setEmail(rs.getString("Email"));
                user.setImage(rs.getBinaryStream("Image"));
                usuarios.add(user);
            }
        } catch (Exception e) {
        	usuarios = null;
        	return null;
        	// MENSAJE DE ERROR
        }
        cn.desconectar();
        return usuarios;
	}
	
	@Override
	public Usuario show(int id) {
	    cn.conectar();
		String sql="SELECT * FROM usuarios WHERE id = " + id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
            	usuario.setId(rs.getInt("Id"));
            	usuario.setNombre(rs.getString("Nombre"));
            	usuario.setEmail(rs.getString("Email"));
            	usuario.setPassword(rs.getString("Password"));
            	//usuario.setImage(rs.getString("Image"));
            }
        } catch (Exception e) {
        	// MENSAJE DE ERROR
        	return null;
        }
        cn.desconectar();
        return usuario;
	}
	
	@Override
	public boolean save(Usuario user) {
	    cn.conectar();
		String query = "INSERT INTO usuarios (nombre, email, password, image) VALUES('"+ user.getNombre() +"', '"+ user.getEmail() +"', '" + user.getPassword() +"', ?) ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.setBlob(1, user.getImage());
            ps.executeUpdate();
        } catch (Exception e) {
        	//MENSAJE DE ERROR
        	return false;
        }
        cn.desconectar();
       return false;
	}
	
	@Override
	public boolean update(Usuario user) {
	    cn.conectar();
	    String query = "";
	    if(user.getPassword() != null) {
	        query = "UPDATE usuarios SET nombre = '" + user.getNombre() + "', email = '" + user.getEmail()+ "', password = '" + user.getPassword() + "' WHERE id = " + user.getId();
	    }else {
	        query = "UPDATE usuarios SET nombre = '" + user.getNombre() + "', email = '" + user.getEmail()+  " WHERE id = " + user.getId();
	    }
		
		try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            
        } catch (Exception e) {
        	return false;
        }
		cn.desconectar();
        return true;
	}
	
	@Override
	public boolean delete(int id) {
	    cn.conectar();
		String query="DELETE FROM usuarios WHERE id = " + id;
		
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
        	// MENSAJE DE ERROR
        	return false;
        }
        cn.desconectar();
		return true;
	}  
	
	/**
     * Verify if User exist and has the correct credentials
     *
     * @param id
     * @param pass
     * @return
     * @throws SQLException
     */
    public Usuario loginValidation(String email, String pass) throws SQLException {
        cn.conectar();
    	String sql="SELECT id FROM usuarios WHERE email = '" + email + "'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
            	usuario = show(rs.getInt("id"));
            }
        } catch (Exception e) {
        	// MENSAJE DE ERROR
        	return null;
        }
        
        if (usuario != null && usuario.getPassword().equals(pass)) {
            return usuario;
        }
        cn.desconectar();
        return null;
    }
    
    public void getImage(int id, HttpServletResponse response) {
        cn.conectar();
        String sql = "SELECT * FROM usuarios where id="+id;
        InputStream is = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        response.setContentType("image/*");
        
        try {
            os = response.getOutputStream();
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
                is = rs.getBinaryStream("image");
            }
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);
            
            int i = 0;
            while((i = bis.read()) != -1) {
                bos.write(i);
            }
        }catch(Exception e) {
            
        }
        cn.desconectar();
    }
}
