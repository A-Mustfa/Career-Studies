import java.sql.*;
public class Main {
    public static void main(String[] args) {
        //url = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(dburl,"sa","123");
            String query = "insert into student (St_Id,st_fname)"+" values (20,'ahmed')";
            PreparedStatement st = con.prepareStatement(query);

            System.out.println(st.executeUpdate());
            con.close();
            st.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}