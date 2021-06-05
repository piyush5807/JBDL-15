package com.company;

public class Employee extends Person implements PersonOperations, PersonDBOperation{

    public Employee(){
        super(0, "");
    }

    private static class EmployeeInfo{

        private String dob;
        private String address;

    }

    private String employeeId;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", age=" + age +
                '}';
    }



    @Override
    public void incrementAgeByOne(){
        super.incrementAgeByOne();
        System.out.println("In increment function of Employee Class");
        this.age++;
    }

    public static void main(String[] args) {

        Employee employee = new Employee();

        EmployeeInfo employeeInfo = new EmployeeInfo();

        System.out.println(employee);

        employee.incrementAgeByOne();

        employee.incrementAge();

        System.out.println(employee.multipleAgeByFactor2(6));
    }

    @Override
    public int incrementAge() {
        System.out.println("current age = " + this.age);
        this.age++;

        System.out.println("new age = " + this.age);

        return this.age;
    }

    @Override
    public int decrementAge() {
        return this.age--;
    }
}
