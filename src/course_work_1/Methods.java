package course_work_1;

import java.util.Arrays;

public class Methods {
    public void addEmployee(String name, int department, int salary) {
        if (Employee.idCounter >= Main.employees.length) {
            System.out.println("Нельзя добавить сотрудника. Лимит: 10 человек.");
        }
        Employee.idCounter++;
        Employee newEmployee = new Employee(name, department, salary);
        Main.employees[Employee.idCounter - 1] = newEmployee;
    }

    public void getAllEmployees() {
        System.out.println(Arrays.toString(Main.employees));
    }

    public int countTotalSalary() {
        int sum = 0;
        for (int i = 0; i < Main.employees.length; i++) {
            sum += Main.employees[i].salary;
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
        return sum;
    }
    public void findMinSalary() {
        int minSalary = Main.employees[0].salary;
        Employee employeeMin = Main.employees[0];
        for (int i = 1; i < Main.employees.length; i++) {
            if (Main.employees[i].salary < minSalary) {
                minSalary = Main.employees[i].salary;
                employeeMin = Main.employees[i];
            }
        }
        System.out.println("С минимальной зарплатой: "+ employeeMin);
    }
    public void findMaxSalary() {
        int maxSalary = Main.employees[0].salary;
        Employee employeeMax = Main.employees[0];
        for (int i = 1; i < Main.employees.length; i++) {
            if (Main.employees[i].salary > maxSalary) {
                maxSalary = Main.employees[i].salary;
                employeeMax = Main.employees[i];
            }
        }
        System.out.println("С максимальной зарплатой: "+ employeeMax);
    }

    public void countAverageSalary() {
        double average = countTotalSalary() / Main.employees.length;
        System.out.println("Средняя зарплата: " + average);
    }

    public void printAllEmployees() {
        System.out.println("Список Ф. И. О. всех сотрудников:");
        for (int i = 0; i < Main.employees.length; i++) {
            System.out.println(Main.employees[i].name);
        }
    }
}

