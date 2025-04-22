import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args){

//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//
//            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true","sa","123");
//            PreparedStatement st = con.prepareStatement("insert into student(st_id,st_fname) values(?,?)");
//            con.setAutoCommit(false);
//            st.setInt(1,30);
//            st.setString(2,"yousef");
//            st.addBatch();
//            st.setInt(1,99);
//            st.setString(2,"you");
//            st.addBatch();
//            st.setInt(1,39);
//            st.setString(2,"seif");
//            st.addBatch();
//
//            int[] result = st.executeBatch();
//            con.commit();
//            for (int i = 0; i < result.length; i++) {
//                System.out.println(result[i]);
//
//            }
//            st.close();;
//            con.close();
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//
//        System.out.println("Hello world!");

//        Student st = new Student(54,"ahmed","ebrahem","cairo",25,10);
//        StudentDAO std = new StudentDAO();
////        System.out.println(std.getAll());
//        ArrayList<Student> arr = std.getAll();
//        for (int i = 0; i < arr.size(); i++) {
//            System.out.println(arr.get(i));
//        }
//
//        System.out.println(std.inserStudent(st));
//        std.clos();

//        String sql = "{call nOfS()}";
//        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true","sa","123");
//        CallableStatement st = con.prepareCall(sql);
//
//        ResultSet rs = st.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getString(1) + " " + rs.getInt(2));
//
//        }
//        st.close();
//        con.close();
        ////////////////////////////////////////////////////// result seeet
//        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true","sa","123");
//        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//
//        ResultSet rs = st.executeQuery("select * from student");
//
//        System.out.println("-----ForWard-------");
//        while (rs.next()){
//            System.out.println(rs.getInt(1) + " " + rs.getString(2));
//        }
//        System.out.println("-----BackWard-------");
//        rs.last();
//        st.executeQuery("insert student(st_id,st_fname) values (5,'islam')");
//        while (rs.previous()){
//            System.out.println(rs.getInt(1) + " " + rs.getString(2));
//        }
//        System.out.println("-----Specific-------");
//        rs.absolute(3);
//        System.out.println(rs.getInt(1) + " " + rs.getString(2));
//
//




    }
}