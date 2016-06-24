package database.classes;

import java.sql.Date;

public class Historial {
	private String nombre, apellidos;
	private int Paciente_ID;
	private Date Antropometricas_Fecha;

	public Historial(String nombre, String apellidos, int paciente_ID, Date antropometricas_Fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		Paciente_ID = paciente_ID;
		Antropometricas_Fecha = antropometricas_Fecha;
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

	public int getPaciente_ID() {
		return Paciente_ID;
	}

	public void setPaciente_ID(int paciente_ID) {
		Paciente_ID = paciente_ID;
	}

	public Date getAntropometricas_Fecha() {
		return Antropometricas_Fecha;
	}

	public void setAntropometricas_Fecha(Date antropometricas_Fecha) {
		Antropometricas_Fecha = antropometricas_Fecha;
	}
}
