import java.sql.*;

public class Student {
    private int age;
    private String fname;
    private String lname;
    private String  adress;
    static Connection con;

    private static final String URL = "jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true";
    private static final String NAME = "sa";
    private static final String PASS = "123";
    private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Student(){
        getConnection();
    }

    public Student(String fname, String lname, String adress,int age) {

        insertStudent(fname,lname,adress,age);
    }

    private Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,NAME,PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    private PreparedStatement getPrep(String sql){
        con = getConnection();
        PreparedStatement pr;
        try {
           pr = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pr;
    }
    private Statement getStatement(){
        con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return st;
    }

    public void insertStudent(String fname,String lname,String address,int age){
        String query = "insert into student(st_fname , st_lname , st_address, st_age) values (? , ? , ? ,? ) ";
        PreparedStatement pr = getPrep(query);
        try {
            pr.setString(1,fname);
            pr.setString(2,lname);
            pr.setString(3,address);
            pr.setInt(4,age);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletetStudent(int id){
        String query = "delete from student where st_id = ? ";
        PreparedStatement pr = getPrep(query);
        try {
            pr.setInt(1,id);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void readStudent(){
        String query = "select * from student";
        Statement st = getStatement();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
            System.out.println("id  "+" fName "+" l name ");
            while (rs.next()){
                System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+ "  " +rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void close(){
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
