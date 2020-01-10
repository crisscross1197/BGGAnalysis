package Database;

import java.sql.*;

public class DatabaseConnector {

	private Connection conn;
	
	public DatabaseConnector(String serverUrl) {
		init(serverUrl);
	}
	
	private void init(String serverUrl) {
		try {
//			try {
//				Class.forName("com.mysql.jdbc.Driver").newInstance();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
			conn = DriverManager.getConnection("jdbc:mysql:" + serverUrl +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "Kristian", "lcrTitsVk4KC43T1EIIe");
		} catch (SQLException e) {
			System.out.println("Could not connect to db at " + serverUrl);
			e.printStackTrace();
		}
	}
	
	public Boolean createTable(String name) {
		if (conn == null) {
			return false;
		} else {
			Statement st;
			try {
				st = conn.createStatement();
				st.execute("CREATE TABLE " + name + " (bgNr INT PRIMARY KEY, bgName VARCHAR(50));");
				return true;
			} catch (SQLException e1) {
				System.out.println("Could not create statement");
				e1.printStackTrace();
				return false;
			}
		}
	}
	
	public Boolean insert(String table, String columns, String values) {
		if (conn == null) {
			return false;
		} else {
			Statement st;
			try {
				st = conn.createStatement();
				st.execute("INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ");");
				return true;
			} catch (SQLException e1) {
				System.out.println("Could not create statement");
				e1.printStackTrace();
				return false;
			}
		}
	}
}
