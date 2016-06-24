package database.operations;

import java.util.ArrayList;

import database.Database;

public class Login {

	public static int[] checkLogin(String user, String pass) throws Exception {
		int[] result = new int[2];
		try {
			ArrayList<String[]> info;
			info = Database.gatherInfo("SELECT * FROM Login");
			for (String[] i : info) {
				if (i[0].equals(user) && i[1].equals(pass)) {

					if (i[2] != null) {
						// Profesional Sanitario
						result[0] = Integer.parseInt(i[2]);
						result[1] = 1;
						return result;
					} else {
						// Paciente
						result[0] = Integer.parseInt(i[3]);
						result[1] = 2;
						return result;
					}
				}
			}
			// Usuario no encontrado
			result[0] = -1;
			result[1] = 0;
			return result;
		} catch (Exception e) {
			System.out.println(e);
			result[0] = -1;
			result[1] = -1;
			return result;
		}
	}
}
