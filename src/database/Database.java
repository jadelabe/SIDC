package database;

import java.io.IOException;
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
			/*if(backup("C:\\Users\\Jadelabe\\Downloads\\")){
				System.out.println("Backup Correcto");
			}*/
			if(restore("C:\\Users\\Jadelabe\\Downloads\\SIDC-03-07-2016.sql")){
				System.out.println("Restore Correcto");
			}
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
			String url = "jdbc:mysql://localhost/SIDC";
			String username = "root";
			String password = "admin";
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
	//Win Only
	public static boolean backup(String path){
	 try {
	        String dbName = "SIDC";
	        String dbUser = "root";
	        String dbPass = "admin";
	        String dbHost = "localhost";
	        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			path = path.replace("\\", "/");
	        String executeCmd = "cmd.exe /c cd \"C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\"  && mysqldump -u" + dbUser + " -p" + dbPass + " -h" + dbHost + " " + dbName + " -r " + path + "SIDC-"+date+".sql";
	        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	        int processComplete = runtimeProcess.waitFor();
	        if (processComplete == 0) {
	        	return true;
	        } else {
	        	return false;
	        }
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	//Win Only
	public static boolean restore(String path) {
        try {
	        String dbName = "SIDC";
	        String dbUser = "root";
	        String dbPass = "admin";
	        String dbHost = "localhost";
			path = path.replace("\\", "/");
            String executeCmd = "cmd.exe /c cd \"C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\"  && mysql -u" + dbUser + " -p" + dbPass + " -h" + dbHost + " " + dbName +" < " + path;

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                return true;
            } else {
                return false;
            }

        } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	        return false;
	    }

    }
}
