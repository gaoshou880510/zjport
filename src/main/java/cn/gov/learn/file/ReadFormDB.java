package cn.gov.learn.file;

import cn.gov.learn.connection.MySqlDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadFormDB {
    public static void main(String[] args) {
        Connection Conn = MySqlDB.getConn();
        Exp(Conn);
    }



    public static void Exp(Connection conn) {
        String file = "E:\\test.txt";
        FileWirte.checkFile(file);
        String Sql = "SELECT loginname,loginpass FROM t_user";
        System.out.println("sql===" + Sql);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            FileWirte.writeContent("username,pwd,id\n", file, true);
            //writeContent("name,pwd\n",file,true);
            while (rs.next()) {
                String name = rs.getString("loginname");
                String pwd = rs.getString("loginpass");
                System.out.println("write --" + name + "," + pwd);
                FileWirte.writeContent(name + "," + pwd + "\n", file, true);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


} 
