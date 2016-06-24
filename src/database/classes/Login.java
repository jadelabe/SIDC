package database.classes;

public class Login {

	private String email, password;
	private int Profesional_Sanitario_ID, Paciente_ID;

	public Login(String email, String password, int profesional_Sanitario_ID, int paciente_ID) {
		super();
		this.email = email;
		this.password = password;
		Profesional_Sanitario_ID = profesional_Sanitario_ID;
		Paciente_ID = paciente_ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProfesional_Sanitario_ID() {
		return Profesional_Sanitario_ID;
	}

	public void setProfesional_Sanitario_ID(int profesional_Sanitario_ID) {
		Profesional_Sanitario_ID = profesional_Sanitario_ID;
	}

	public int getPaciente_ID() {
		return Paciente_ID;
	}

	public void setPaciente_ID(int paciente_ID) {
		Paciente_ID = paciente_ID;
	}

}
