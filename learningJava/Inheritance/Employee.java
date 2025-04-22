public class Employee {
    private String name;
    private String email;
    private String phone;
    private String department;
    private String address;
    protected int yearOfBirth;
    private float salary;
    public Employee(){
        System.out.println("un parameterized constructor");
    }
    public Employee(String name,String email,String phone,String department,String address,int yearOfBirth,float salary){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.department=department;
        this.address=address;
        this.yearOfBirth=yearOfBirth;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

}
