/**
 * 
 */
package nombredominio.models;

/**
 * @author sergio
 *
 */
public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String password;
	private String image;
	/**
	 * @param id
	 * @param nombre
	 * @param email
	 * @param password
	 * @param image
	 */
	public Usuario(int id, String nombre, String email, String password, String image) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.image = image;
	}
	
	public Usuario() {}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
}
