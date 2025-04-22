public class Developer extends Employee{
    private String projectName;
    private int bounes;
    public Developer(){
        System.out.println("sub class");
    }
    public Developer(String name,String email,String phone,String department,String address,int yearOfBirth,float salary,int bounes){
        super(name,email,phone,department,address,yearOfBirth,salary);
        this.bounes=bounes;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public float getSalary(){
        return super.getSalary()+bounes;
    }

}
