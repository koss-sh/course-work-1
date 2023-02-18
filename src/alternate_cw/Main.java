package alternate_cw;

import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printFullInfo();
        System.out.println("Сумма ЗП: " + totalSalaries());
        System.out.println("Сотрудник с мин ЗП: " + findMinSalaryEmployee());
        System.out.println("Сотрудник с макс ЗП: " + findMaxSalaryEmployee());
        System.out.println("Средняя ЗП: " + findAverageSalary());
        printFullNameInfo();

        double indexPercent = 8.5;
        indexSalary(indexPercent);
        System.out.printf("ЗП после индексации на %.2f%%%n", indexPercent);
        printFullInfo();

        int department = 3;
        System.out.printf("Сотрудник с мин ЗП из отдела %d: %s%n", department, findMinSalaryEmployee(department));
        System.out.printf("Сотрудник с мин ЗП из отдела %d: %s%n", department, findMaxSalaryEmployee(department));
        System.out.printf("Сумма ЗП по отделу %d: %d%n", department, totalSalaries(department));
        System.out.printf("Средняя ЗП по отделу %d: %.2f%n", department, findAverageSalary(department));

        double indexDeptPercent = 10;
        indexSalary(indexDeptPercent, department);
        System.out.printf("ЗП после индексации на %.2f%% сотрудников отдела %d%n", indexDeptPercent, department);
        printFullInfo(department);
    }
    private static void fillEmployees() {
        Random random = new Random();
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = new Employee("Сотрудник " + (i+1),
                    random.nextInt(5) + 1,
                    random.nextInt(45000) + 45000);

        }
    }
    private static void printFullInfo() {
        for(Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }
    private static int totalSalaries() {
        int sum = 0;
        for(Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }
    private static Employee findMinSalaryEmployee() {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for(Employee emp : EMPLOYEES) {
            if (emp.getSalary() < min) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    private static Employee findMaxSalaryEmployee() {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for(Employee emp : EMPLOYEES) {
            if (emp.getSalary() > max) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    private static double findAverageSalary() {
        return totalSalaries() / (double) EMPLOYEES.length;
    }
    private static void printFullNameInfo() {
        for(Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
    /* Средний уровень */
    private static void indexSalary(double percent) {
        double coeff = 1 + percent / 100;
        for(Employee employee : EMPLOYEES) {
            employee.setSalary((int) ( employee.getSalary() * coeff));
        }
    }
    private static Employee findMinSalaryEmployee(int department) {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for(Employee emp : EMPLOYEES) {
            if (emp.getSalary() < min && emp.getDepartment() == department) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    private static Employee findMaxSalaryEmployee(int department) {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for(Employee emp : EMPLOYEES) {
            if (emp.getSalary() > max && emp.getDepartment() == department) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    private static int totalSalaries(int department) {
        int sum = 0;
        for(Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department)
            sum += employee.getSalary();
        }
        return sum;
    }
    private static double findAverageSalary(int department) {
        int count = 0;
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        if (count != 0){
            return  sum / count;
        } else {
            return  0;
        }
    }
    private static void indexSalary(double percent, int department) {
        double coeff = 1 + percent / 100;
        for(Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * coeff));
            }
        }
    }
    private static void printFullInfo(int department) {
        System.out.println("Сотрудники отдела " + department);
        for(Employee employee : EMPLOYEES) {
            if (employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }
}
