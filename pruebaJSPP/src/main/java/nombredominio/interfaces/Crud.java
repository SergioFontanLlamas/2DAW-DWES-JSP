/**
 * 
 */
package nombredominio.interfaces;

import nombredominio.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergio
 *
 */
public interface Crud {
	/* Metodo que devuelve todos los elementos */
	public ArrayList<Usuario> all();
	
	/* Metodo que devuelve un elemento filtrado por id */
    public Usuario show(int id);
    
    /* Metodo que guarda un elemento */
    public boolean save(Usuario per);
    
    /* Metodo que actualiza un elemento */
    public boolean update(Usuario per);
    
    /* Metodo que elimina un elemento */
    public boolean delete(int id);
}
