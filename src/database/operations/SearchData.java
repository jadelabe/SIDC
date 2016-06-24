package database.operations;

import java.util.ArrayList;

import database.Database;

public class SearchData {

	public static ArrayList<String[]> search(String table, String column, String parameter){
		try {
			String sql = "Select * from "+table+" where "+column+" like '%"+parameter+"%'";
			return Database.gatherInfo(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public static ArrayList<String[]> search(String table){
		try {
			String sql = "Select * from "+table;
			return Database.gatherInfo(sql);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
