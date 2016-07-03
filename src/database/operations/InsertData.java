package database.operations;

/*import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;*/

import database.Database;
import database.classes.Antropometricas;
import database.classes.Historial;
import database.classes.Login;
import database.classes.Paciente;
import database.classes.Profesional_Sanitario;

public class InsertData {
/*
	public static void main(String[] args) throws Exception{
		Profesional_Sanitario ps = new Profesional_Sanitario("admin", "nomadmin", "apeadmin", "C/ La piruleta", 666777888);
		writeProfesionalSanitario(ps);
		byte[] salt = security.Encryption.generateSalt();
		String password = security.Encryption.encryptPassword("admin", salt);
		Login l = new Login("admin", password, 1, 1);
		writeLoginAdmin(l);
	}
*/
	// Da problemas al escribir de seguido al tener como clave primaria una
	// marca de tiempo
	public static boolean writeAntropometricas(Antropometricas a) throws Exception {
		try {
			return Database.updateInfo(
					"INSERT INTO Antropometricas ( talla, peso, cintura, cadera, pecho, pliegue_escapular, pliegue_bicipital, pliegue_tricipital, pliegue_abdominal, IMC, IGC, TMB, Paciente_ID) VALUES('"
							+ a.getTalla() + "', '" + a.getPeso() + "', '" + a.getCintura() + "', '" + a.getCadera() + "', '"
							+ a.getPecho() + "', '" + a.getPliegue_escapular() + "', '" + a.getPliegue_bicipital() + "', '"
							+ a.getPliegue_tricipital() + "', '" + a.getPligue_abdominal() + "', '" + a.getImc() + "', '"
							+ a.getIgc() + "', '" + a.getTmb() + "', (select ID from Paciente where ID = "
							+ a.getPaciente_ID() + "))");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// Esto creoq puede estar algo buggy por usar nombre y apellidos para
	// obtener el ID, o por usar el ID para la fecha
	public static boolean writeHistorial(Historial h) throws Exception {
		try {
			return Database
					.updateInfo("INSERT INTO Historial ( nombre, apellidos, Paciente_ID, Antropometricas_Fecha) VALUES('"
							+ h.getNombre() + "', '" + h.getApellidos() + "', (select ID from Paciente where nombre = "
							+ h.getNombre() + " AND  apellidos = " + h.getApellidos()
							+ ")), (select fecha from Antropometricas where Paciente_ID = " + h.getPaciente_ID());
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean writeLoginAdmin(Login l) throws Exception {
		try {
			byte[] salt = security.Encryption.generateSalt();
			return Database.updateInfo("INSERT INTO Login ( email, password, Profesional_Sanitario_ID) VALUES('"
					+ l.getEmail() + "', '" + security.Encryption.encryptPassword(l.getPassword(), salt) + "', (select ID from Profesional_Sanitario where email = '"
					+ l.getEmail() + "'))");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean writeLoginUser(Login l) throws Exception {
		try {
			byte[] salt = security.Encryption.generateSalt();
			return Database.updateInfo(
					"INSERT INTO Login ( email, password, Profesional_Sanitario_ID) VALUES('" + l.getEmail() + "', '"
							+ security.Encryption.encryptPassword(l.getPassword(), salt) + "', (select ID from Paciente where email = '" + l.getEmail() + "'))");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean writeProfesionalSanitario(Profesional_Sanitario ps) throws Exception {
		try {
			return Database.updateInfo("INSERT INTO Profesional_Sanitario (email, nombre, apellidos, direccion, telefono) VALUES ('"
					+ ps.getEmail() + "', '" + ps.getNombre() + "', '" + ps.getApellidos() + "', '" + ps.getDireccion()+ "', '" + ps.getTelefono() + "')");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean writePaciente(Paciente p, int profesional_sanitario) throws Exception {
		try {
			return Database.updateInfo(
					"INSERT INTO Paciente (nombre, apellidos, email, direccion, fecha_nacimiento, telefono) VALUES('"
							+ p.getNombre() + "', '" + p.getApellidos() + "', '" + p.getEmail() + "', '"
							+ p.getDireccion() + "', '" + p.getFecha_nacimiento() + "', '"
							+ p.getTelefono() +"')");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
