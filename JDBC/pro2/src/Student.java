public class Student {
    private int st_id;
    private String st_fname;
    private String st_lname;
    private String st_address;
    private int st_age;
    private int Dept_id;
    public Student(){

    }

    public Student(int st_id, String st_fname, String st_lname, String st_address, int st_age, int dept_id) {
        this.st_id = st_id;
        this.st_fname = st_fname;
        this.st_lname = st_lname;
        this.st_address = st_address;
        this.st_age = st_age;
        Dept_id = dept_id;
    }

    public int getSt_id() {
        return st_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_id=" + st_id +
                ", st_fname='" + st_fname + '\'' +
                ", st_lname='" + st_lname + '\'' +
                ", st_address='" + st_address + '\'' +
                ", st_age=" + st_age +
                ", Dept_id=" + Dept_id +
                '}';
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getSt_fname() {
        return st_fname;
    }

    public void setSt_fname(String st_fname) {
        this.st_fname = st_fname;
    }

    public String getSt_lname() {
        return st_lname;
    }

    public void setSt_lname(String st_lname) {
        this.st_lname = st_lname;
    }

    public String getSt_address() {
        return st_address;
    }

    public void setSt_address(String st_address) {
        this.st_address = st_address;
    }

    public int getSt_age() {
        return st_age;
    }

    public void setSt_age(int st_age) {
        this.st_age = st_age;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int dept_id) {
        Dept_id = dept_id;
    }
}
