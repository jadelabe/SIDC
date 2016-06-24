package database.operations;

import database.Database;

public class DeleteData {

	//Elimina de la tabla las entradas que contengan parameter en la columna indicada
	
	public static boolean deleteData(String table, String column, String parameter){
		try {
			String sql = "DELETE FROM "+table+" where "+column+" like '%"+parameter+"%'";
			Database.updateInfo(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
