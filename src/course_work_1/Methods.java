package course_work_1;

import java.util.Arrays;

public class Methods {
    public static void addEmployee(String name, int department, double salary) {
        if (Employee.getIdCounter() == Main.employees.length) {
            System.out.println("Нельзя добавить сотрудника. Лимит: 10 человек.");
        }
        Employee newEmployee = new Employee(name, department, salary);
        Main.employees[Employee.getIdCounter()] = newEmployee;
        Employee.idCounter++;
    }

    public static void getAllEmployees() {
        System.out.println(Arrays.toString(Main.employees));
    }

    public static double countTotalSalary() {
        double sum = 0;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            sum += Main.employees[i].getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
        return sum;
    }
    public static void findMinSalary() {
        double minSalary = Main.employees[0].getSalary();
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
        double maxSalary = Main.employees[0].getSalary();
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

    public static void indexAllSalaries() {
        double index = 10; // индексация зарплаты в %
        double newSalary;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            newSalary = Main.employees[i].getSalary() * (1 + index / 100);
            Main.employees[i].setSalary(newSalary);
        }
    }
    public static void findDeptMinSalary(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        double minDeptSalary = 0;
        Employee employeeMin = Main.employees[0];
        int i;
        for (i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                minDeptSalary = Main.employees[i].getSalary();
                employeeMin = Main.employees[i];
                break;
            }
        }
        for (int k = i++; k < Employee.getIdCounter(); k++) {
            if(Main.employees[k].getDepartment() == department && Main.employees[k].getSalary() < minDeptSalary) {
                minDeptSalary = Main.employees[k].getSalary();
                employeeMin = Main.employees[k];
            }
        }
        System.out.println("Минимальная зарплата в отделе " + department + ": " + minDeptSalary + ", сотрудник: " + employeeMin.getName());
    }
    public static void findDeptMaxSalary(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        double maxDeptSalary = 0;
        Employee employeeMax = Main.employees[0];
        int i;
        for (i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                maxDeptSalary = Main.employees[i].getSalary();
                employeeMax = Main.employees[i];
                break;
            }
        }
        for (int k = i++; k < Employee.getIdCounter(); k++) {
            if(Main.employees[k].getDepartment() == department && Main.employees[k].getSalary() > maxDeptSalary) {
                maxDeptSalary = Main.employees[k].getSalary();
                employeeMax = Main.employees[k];
            }
        }
        System.out.println("Максимальная зарплата в отделе " + department + ": " + maxDeptSalary + ", сотрудник: " + employeeMax.getName());
    }
    public static void countTotalDeptSalary(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        double sum = 0;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                sum += Main.employees[i].getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц по отделу " + department + " составляет: " + sum);
    }
    public static void countAverageDeptSalary(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        double sum = 0;
        int empNumber = 0;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                empNumber++;
                sum += Main.employees[i].getSalary();
            }
        }
        System.out.println("Средняя зарплата по отделу " + department + " составляет: " + sum / empNumber);
    }
    public static void indexAllDeptSalaries(int department, double index) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        double newSalary;
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                newSalary = Main.employees[i].getSalary() * (1 + index / 100);
                Main.employees[i].setSalary(newSalary);
            }
        }
    }
    public static void printDeptAllEmployees(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Такого отдела не существует");
            return;
        }
        System.out.println("Список всех сотрудников отдела " + department + ":");
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getDepartment() == department) {
                System.out.println("№" + Main.employees[i].getId() + ", " + Main.employees[i].getName() + ", " + Main.employees[i].getSalary());
            }
        }
    }
    public static void printEmployeesLessThanSalary(double salary) {
        System.out.println("Сотрудники с зарплатой ниже " + salary + ":");
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getSalary() < salary) {
                System.out.println("№" + Main.employees[i].getId() + ", " + Main.employees[i].getName() + ", " + Main.employees[i].getSalary());
            }
        }
    }
    public static void printEmployeesMoreThanSalary(double salary) {
        System.out.println("Сотрудники с зарплатой выше " + salary + ":");
        for (int i = 0; i < Employee.getIdCounter(); i++) {
            if (Main.employees[i].getSalary() > salary) {
                System.out.println("№" + Main.employees[i].getId() + ", " + Main.employees[i].getName() + ", " + Main.employees[i].getSalary());
            }
        }
    }
}

