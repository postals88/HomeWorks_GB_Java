package lesson4;

public class Employee {
    private String name;
    private String lastName;
    private String position;
    private long telNumber;
    private int salary;
    private int age;

    public Employee(String name, String lastName, String position, long telNumber, int salary, int age) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.telNumber = telNumber;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPosition() {
        return this.position;
    }

    public long getTelNumber() {
        return this.telNumber;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

