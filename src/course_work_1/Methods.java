package course_work_1;

import java.util.Arrays;

public class Methods {
    public static void addEmployee(String name, int department, int salary) {
        if (Employee.getIdCounter() == Main.employees.length) {
            System.out.println("Нельзя добавить сотрудника. Лимит: 10 человек.");
        }
        Employee.idCounter++;
        Employee newEmployee = new Employee(name, department, salary);
        Main.employees[Employee.getIdCounter() - 1] = newEmployee;
    }

    public static void getAllEmployees() {
        System.out.println(Arrays.toString(Main.employees));
    }

    public static int countTotalSalary() {
        int sum = 0;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            sum += Main.employees[i].getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
        return sum;
    }
    public static void findMinSalary() {
        int minSalary = Main.employees[0].getSalary();
        Employee employeeMin = Main.employees[0];
        for (int i = 1; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getSalary() < minSalary) {
                minSalary = Main.employees[i].getSalary();
                employeeMin = Main.employees[i];
            }
        }
        System.out.println("С минимальной зарплатой: "+ employeeMin);
    }
    public static void findMaxSalary() {
        int maxSalary = Main.employees[0].getSalary();
        Employee employeeMax = Main.employees[0];
        for (int i = 1; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getSalary() > maxSalary) {
                maxSalary = Main.employees[i].getSalary();
                employeeMax = Main.employees[i];
            }
        }
        System.out.println("С максимальной зарплатой: "+ employeeMax);
    }

    public static void countAverageSalary() {
        double average = (double) countTotalSalary() / Employee.getIdCounter();
        System.out.println("Средняя зарплата: " + average);
    }

    public static void printAllEmployees() {
        System.out.println("Список Ф. И. О. всех сотрудников:");
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            System.out.println(Main.employees[i].getName());
        }
    }
}

