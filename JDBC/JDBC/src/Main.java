
import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true","sa","123");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Student");
//        Statement st = con.createStatement();;
//        con.setAutoCommit(false);
//
//
////        String Query = "insert into Student(st_id,st_fname) values( ? , ?)";
////        PreparedStatement ps = con.prepareStatement(Query);
////        ps.setInt(1,13);
////        ps.setString(2,"abdl");
////        ps.executeUpdate();
////
////        PreparedStatement ps2 = con.prepareStatement("delete from Student where st_fname = ?");
////        ps2.setString(1,"said");
////        ps2.executeUpdate();
//
//        String Query = "update Student set st_age = 15 where st_fname ='noha' ";
//        st.addBatch(Query);
//        String Query2 = "update Student set st_age = 10 where st_fname = 'ahmed' ";
//        st.addBatch(Query2);
//        int [] count = st.executeBatch();
//
//
//        con.commit();
//
//
//
//       for (int n : count)
//       {
//           System.out.println(n);
//       }
        //////////////////////////////////////////




        while(rs.next()){
//            System.out.println(rs.getString(2));
//        }
//        System.out.println("--------");
//        rs.afterLast();
//        while(rs.previous()){
//            System.out.println(rs.getString(2));
//        }
//        con.close();
////        st.close();
//        ps.close();
    }
}