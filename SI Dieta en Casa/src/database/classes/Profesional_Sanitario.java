package database.classes;

import java.util.ArrayList;

public class Profesional_Sanitario {
	private int ID;
	private String email, nombre, apellidos, direccion;
	private int telefono;

	public Profesional_Sanitario(int iD, String email, String nombre, String apellidos, String direccion,
			int telefono) {
		super();
		ID = iD;
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	public Profesional_Sanitario(String email, String nombre, String apellidos, String direccion,
			int telefono) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Profesional_Sanitario(ArrayList<String[]> userInfo) {
		// TODO Auto-generated constructor stub
		String fields[]  = userInfo.get(0);
		ID = Integer.parseInt(fields[0]);
		email = fields[1];
		nombre = fields[2];
		apellidos = fields[3];
		/*direccion = fields[4];
		telefono = Integer.parseInt(fields[5]);*/
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
