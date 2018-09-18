package cn.gov.learn.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class OracleTest {
	

	
	private static Connection getConn() {
	    String driver = "oracle.jdbc.driver.OracleDriver";
	    String url = "jdbc:oracle:thin:@192.168.3.55:1521:zjporttest";
	    String username = "maacus";
	    String password = "maacus";
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,���ض�Ӧ����
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static int insert(String id, String name, String pwd) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into MAA_TESTUSER(id,user_name,password) values(?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, name);
	        pstmt.setString(3, pwd);
	        i = pstmt.executeUpdate();
	        System.out.println( i );
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	    	//error
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	
	public static void main(String[] args) {
//		for(int i=0;i<10;i++){
//		 String id = UUID.randomUUID().toString();
//		 OracleTest.insert(id, "111", "TESTPWD");
//		}
		OracleTest.insert("2", "TEST1", "TESTPWD");
	}
	

}
