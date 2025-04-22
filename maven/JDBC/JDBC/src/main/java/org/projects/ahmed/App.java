package org.projects.ahmed;

/**
 * Hello world!
 *
 */
import java.sql.*;
public class App 
{
    public static void main ( String[] args ) throws SQLException
    {
       
        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true","sa","123");
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery("select * from student");
        System.out.println("id" + " " + "name");
        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        st.close();
        rs.close();
    }
}
