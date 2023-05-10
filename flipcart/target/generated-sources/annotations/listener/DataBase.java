package listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private String url;
	private String id;
	private String pass;
	private Connection c;
	public DataBase(String url, String id, String pass) {
		super();
		this.url = url;
		this.id = id;
		this.pass = pass;
	}
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, id, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.c;
		
	}

}
