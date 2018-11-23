package DAO;
import java.sql.*;
/*
 * Registers Driver
 * Connects to Database
 * Safely closes connection
 */

public abstract class AbstractDAO {
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "conwabueze";
	private final String password = "drkb";
	private final Driver driver = new oracle.jdbc.driver.OracleDriver();
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void connect(){
		try {
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			System.out.println(e);		
		}
		
	}
	
	public void dispose() {
		try {
				if(!rs.equals(null) && !rs.isClosed())
					rs.close();
				if(!ps.equals(null) && !ps.isClosed())
					ps.close();
				if(!conn.equals(null) && !conn.isClosed())
					conn.close();
		}catch(SQLException e) {
			System.out.println("Had a problem closing");
		}
	}

}
