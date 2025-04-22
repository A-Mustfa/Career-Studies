package SOLID.S;

public class Employee {
    // let's consider that this is employee class, this class must be only doing one job and open it to edit only this job
    private String emp_name;
    private int emp_age;
    public Employee(String name, int age){
        this.emp_name = name;
        this.emp_age = age;
    }
    public int getEmpAge(){
        return this.emp_age;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    /*
    the next method is bad example and violate the s principle
    because we will have to come here and edit unnecessary method for the class
    So we have to move it to another class
    */
    public void PrintCustomersAge(){
        System.out.println("Hello, welcome the customer age is: " + 25);
    }


}
