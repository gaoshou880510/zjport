package cn.gov.learn.connection;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class MySqlDB {

    public static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.3.131:3306/goods";
        String username = "root";
        String password = "MyPassword";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载相应驱动
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
        String sql = "insert into t_user (uid,loginname,loginpass) values(?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pwd);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    public static void main(String[] args) {
        //MySqlDB db =new MySqlDB();

        // int reulst = MySqlDB.insert("123","test111","test111");

        for (int i = 0; i < 2; i++) {
            String uid = UUID.randomUUID().toString();
            int reulst = MySqlDB.insert(uid, "testfan" + i, "test" + i);
            System.out.println("reulst " + i);
        }

    }
}
	
	
