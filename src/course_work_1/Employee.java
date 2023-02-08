package course_work_1;

public class Employee {
    private final String name;
    private int department;
    private double salary;
    public static int idCounter;
    private int id;

    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        id = idCounter + 1;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник № " + id +
                ", " + name +
                ", отдел: " + department +
                ", зарплата: " + salary;
    }
}

