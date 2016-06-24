package database.classes;

import java.sql.Date;
import java.util.ArrayList;

public class Paciente {
	private int ID;


	private String nombre, apellidos, email, direccion;
	private Date fecha_nacimiento, fecha_creacion;
	private int Profesional_Sanitario_ID;
	private int telefono;

	public Paciente(int iD, String nombre, String apellidos, String email, String direccion, Date fecha_nacimiento,
			Date fecha_creacion, int profesional_Sanitario_ID, int telefono) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_creacion = fecha_creacion;
		Profesional_Sanitario_ID = profesional_Sanitario_ID;
		this.telefono = telefono;
	}
	public Paciente(String nombre, String apellidos, String email, String direccion, Date fecha_nacimiento,
			int profesional_Sanitario_ID, int telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.fecha_nacimiento = fecha_nacimiento;
		Profesional_Sanitario_ID = profesional_Sanitario_ID;
		this.telefono = telefono;
	}

	public Paciente(ArrayList<String[]> userInfo) {
		// TODO Auto-generated constructor stub
		String fields[]  = userInfo.get(0);
		ID = Integer.parseInt(fields[0]);
		email = fields[1];
		nombre = fields[2];
		apellidos = fields[3];
		direccion = fields[4];
		telefono = Integer.parseInt(fields[5]);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public int getProfesional_Sanitario_ID() {
		return Profesional_Sanitario_ID;
	}

	public void setProfesional_Sanitario_ID(int profesional_Sanitario_ID) {
		Profesional_Sanitario_ID = profesional_Sanitario_ID;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
