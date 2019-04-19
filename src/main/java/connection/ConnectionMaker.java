package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionMaker {
	
	private static final Properties props = getJdbcProperties();
	
	private ConnectionMaker() {}
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(props.getProperty("jdbc.url"), 
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
		} catch (SQLException err) {
			System.err.println("SQL error state: " + err.getSQLState());
			System.err.println("SQL error code: " + err.getErrorCode());
			throw new RuntimeException("Failed Connection to Database");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("Failed to load Oracle database driver");
		}
	}
	
	private static Properties getJdbcProperties() {
		System.out.println("in properties");
		Properties props = new Properties();
		System.out.println("got properties");
		try {
			System.out.println("in try block");
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException err) {
			throw new RuntimeException("Failed to load applications.properties");
		}
		System.out.println("returning props "+props);
		return props;
	}
	
}
