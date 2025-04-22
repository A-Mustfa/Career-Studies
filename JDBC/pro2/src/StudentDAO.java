import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    private final String DB_URL = "jdbc:sqlserver://DESKTOP-SHD0QMQ:1433;databaseName=iti;encrypt=true;trustServerCertificate=true";
    private final String PASS = "123";
    private final String USER = "sa";
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private Connection con = null;
    private Statement st = null;
    private PreparedStatement pre = null;
    private Student stud;
    private ArrayList<Student> students = new ArrayList<>();
    public StudentDAO(){
        connect();
    }
    public ArrayList<Student> getAll(){
        String query = "select * from student";
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                stud = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                students.add(stud);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    private void connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void clos(){
        try {
            con.close();
            st.close();
//            pre.close();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }
    }
    public boolean inserStudent(Student student){
        int x ;
        try {
            pre = con.prepareStatement("insert into Student(st_id,st_fname,st_lname,st_address,st_age,dept_id) values(?,?,?,?,?,?)");
            pre.setInt(1,student.getSt_id());
            pre.setString(2,student.getSt_fname());
            pre.setString(3,student.getSt_lname());
            pre.setString(4,student.getSt_address());
            pre.setInt(5,student.getSt_age());
            pre.setInt(6,student.getDept_id());
            x = pre.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return x>0? true:false;

    }


}
