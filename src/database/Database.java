package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Database {

	public static void main(String[] args){
		try {
			backupDatabase(createStatement(getConnection()), "C:\\Users\\Jadelabe\\Downloads");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	/**
	 * @return Database Connection
	 * @throws Exception
	 */
	private static Connection getConnection() throws Exception {
		try {
			String driver = "org.sqlite.JDBC";
			String url = "jdbc:sqlite:SIDC.sqlite";
			String username = "username";
			String password = "password";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * @param connection
	 *            to the database we want to create a Statement for
	 * @return Statement for the database
	 * @throws Exception
	 */
	private static Statement createStatement(Connection connection) throws Exception {
		try {
			return connection.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Used for getting data from the database in ResultSet form
	 * 
	 * @param statement
	 *            already created for the database
	 * @param sql
	 *            String with the message we want to send to the database
	 * @return ResultSet of the message
	 */
	private static ResultSet executeQuery(Statement statement, String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * @param sql
	 *            String with the message we want to send to the database, must
	 *            be an SQL INSERT, UPDATE or DELETE statement; or an SQL
	 *            statement that returns nothing, such as a DDL statement.
	 * @return true if executed properly, false otherwise
	 * @throws Exception
	 */
	public static boolean updateInfo(String sql) throws Exception {
		try {
			createStatement(getConnection()).executeUpdate(sql);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * @param sql
	 *            String with the message we want to send to the database
	 * @return Parsed ResultSet in an ArrayList<String[]> where the slot 0 of
	 *         the Sting are the info in the row 0 of the database, and so on
	 * @throws Exception
	 */
	public static ArrayList<String[]> gatherInfo(String sql) throws Exception {
		try {
			ResultSet data;
			data = executeQuery(createStatement(getConnection()), sql);
			int size = data.getMetaData().getColumnCount();
			
			ArrayList<String[]> info = new ArrayList<String[]>();
			while (data.next()) {
				String[] row = new String[size];
				for (int i = 0; i < size; i++) {
					row[i] = data.getString(i+1);
				}
				info.add(row);
			}
			return info;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static boolean backup(String path){
		try {
			return backupDatabase(createStatement(getConnection()), path);	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	public static boolean backupDatabase(Statement stmt, String path){
		try {
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			path = path.replace("\\", "/");
			stmt.executeUpdate("backup to "+path+"/SIDC-"+date+".sqlite.bak");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public static boolean restoreDatabase(Statement stmt, String path){
		try {
			path = path.replace("\\", "/");
			stmt.executeUpdate("restore from "+path);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	public static boolean restore(String path){
		try {
			return restoreDatabase(createStatement(getConnection()), path);	
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
}
