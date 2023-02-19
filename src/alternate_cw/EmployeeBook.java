package alternate_cw;

import java.util.Random;


public class EmployeeBook {

    private static final int SIZE = 10;

    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[SIZE];
    }


   public void printFullInfo() {
        System.out.println("Все сотрудники");
        for(Employee employee : employees) {
                System.out.println(employee);
        }
    }
    public int totalSalaries() {
        int sum = 0;
        for(Employee employee : employees) {
            if(employee != null){
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    public Employee findMinSalaryEmployee() {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for(Employee emp : employees) {
            if (emp != null && emp.getSalary() < min) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public Employee findMaxSalaryEmployee() {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for(Employee emp : employees) {
            if (emp != null && emp.getSalary() > max) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public double findAverageSalary() {
        return totalSalaries() / (double) employees.length;
    }
    public void printFullNameInfo() {
        for(Employee employee : employees) {
            if(employee != null){
                System.out.println(employee.getFullName());
            }
        }
    }
    /* Средний уровень */
    public void indexSalary(double percent) {
        double coeff = 1 + percent / 100;
        for(Employee employee : employees) {
            if(employee != null){
                employee.setSalary((int) ( employee.getSalary() * coeff));
            }
        }
    }
    public Employee findMinSalaryEmployee(int department) {
        int min = Integer.MAX_VALUE;
        Employee employee = null;
        for(Employee emp : employees) {
            if (emp != null && emp.getSalary() < min && emp.getDepartment() == department) {
                min = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public Employee findMaxSalaryEmployee(int department) {
        int max = Integer.MIN_VALUE;
        Employee employee = null;
        for(Employee emp : employees) {
            if (emp != null && emp.getSalary() > max && emp.getDepartment() == department) {
                max = emp.getSalary();
                employee = emp;
            }
        }
        return employee;
    }
    public int totalSalaries(int department) {
        int sum = 0;
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department)
                sum += employee.getSalary();
        }
        return sum;
    }
    public double findAverageSalary(int department) {
        int count = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
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
    public void indexSalary(double percent, int department) {
        double coeff = 1 + percent / 100;
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary((int) (employee.getSalary() * coeff));
            }
        }
    }
    public void printFullInfo(int department) {
        System.out.println("Сотрудники отдела " + department);
        for(Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("id: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }
    public void printEmployeeWithSalaryLessThan (int salary) {
        System.out.println("Сотрудники с ЗП меньшей, чем " + salary);
        for(Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("id: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }
    public void printEmployeeWithSalaryMoreThan (int salary) {
        System.out.println("Сотрудники с ЗП большей. чем " + salary);
        for(Employee employee : employees) {
            if (employee != null && employee.getSalary() > salary) {
                System.out.println("id: " + employee.getId() + ", ФИО: " + employee.getFullName() + ", ЗП: " + employee.getSalary());
            }
        }
    }
    public void addEmployee (Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }
    public void removeEmployee (String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
                break;
            }
        }
    }
    public void removeEmployee (int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                break;
            }
        }
    }
    private Employee findEmployeeByFullname (String fullName) {
        for(Employee employee : employees) {
            if (employee != null && employee.getFullName().equals(fullName)) {
                return employee;
            }
        }
        return  null;
    }
    public void changeSalary(String fullName, int newSalary) {
        Employee employee = findEmployeeByFullname(fullName);
        if (employee != null) {
            employee.setSalary(newSalary);
        }
    }
    public void changeDepartment(String fullName, int newDepartment) {
        Employee employee = findEmployeeByFullname(fullName);
        if (employee != null) {
            employee.setDepartment(newDepartment);
        }
    }
    public void printEmployeesByDepartments() {
        for (int department = 1; department <= 5 ; department++) {
            StringBuilder result = new StringBuilder();
            for (Employee employee :employees) {
                if (employee != null && employee.getDepartment() == department) {
                    result.append(employee).append("\n");
                }
            }
            if (result.length() != 0) {
                System.out.println("Сотрудники отдела " + department + "\n" + result);
            }


        }
    }
}
