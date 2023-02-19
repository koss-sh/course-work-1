package alternate_cw;

import java.util.Random;

public class EmployeeBookMain {

    private static final Random RANDOM = new Random();
    private static String[] firstNames = {"Константин", "Евгений", "Юрий", "Игорь", "Василий", "Денис", "Алексей"};
    private static String[] middleNames = {"Константинович", "Евгеньевич", "Юрьевич", "Игоревич", "Васильевич", "Денисович", "Алексеевич"};
    private static String[] lastNames = {"Константинов", "Евгеньев", "Юрьев", "Игорев", "Васильев", "Денисов", "Алексеев"};

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        for (int i = 0; i < 7; i++) {
            employeeBook.addEmployee(generate());
        }
        employeeBook.printFullInfo();
        employeeBook.removeEmployee(employeeBook.findMinSalaryEmployee().getId());
        employeeBook.printFullInfo();
        employeeBook.changeDepartment(employeeBook.findMinSalaryEmployee().getFullName(), 10);
        employeeBook.changeSalary(employeeBook.findMaxSalaryEmployee().getFullName(), 0);
        employeeBook.printFullInfo();
        employeeBook.printEmployeesByDepartments();
        System.out.println("Сумма ЗП: " + employeeBook.totalSalaries());
        System.out.println("Сотрудник с мин ЗП: " + employeeBook.findMinSalaryEmployee());
        System.out.println("Сотрудник с макс ЗП: " + employeeBook.findMaxSalaryEmployee());
        System.out.println("Средняя ЗП: " + employeeBook.findAverageSalary());
        employeeBook.printFullNameInfo();

        double indexPercent = 8.5;
        employeeBook.indexSalary(indexPercent);
        System.out.printf("ЗП после индексации на %.2f%%%n", indexPercent);
        employeeBook.printFullInfo();

        int department = 3;
        System.out.printf("Сотрудник с мин ЗП из отдела %d: %s%n", department, employeeBook.findMinSalaryEmployee(department));
        System.out.printf("Сотрудник с мин ЗП из отдела %d: %s%n", department, employeeBook.findMaxSalaryEmployee(department));
        System.out.printf("Сумма ЗП по отделу %d: %d%n", department, employeeBook.totalSalaries(department));
        System.out.printf("Средняя ЗП по отделу %d: %.2f%n", department, employeeBook.findAverageSalary(department));

        double indexDeptPercent = 10;
        employeeBook.indexSalary(indexDeptPercent, department);
        System.out.printf("ЗП после индексации на %.2f%% сотрудников отдела %d%n", indexDeptPercent, department);
        employeeBook.printFullInfo(department);

        int salary = 70000;
        employeeBook.printEmployeeWithSalaryLessThan (salary);
        employeeBook.printEmployeeWithSalaryMoreThan (salary);

    }
    private static Employee generate() {
        String fullName = firstNames[RANDOM.nextInt(firstNames.length)] + " " +
                middleNames[RANDOM.nextInt(middleNames.length)] + " " +
                lastNames[RANDOM.nextInt(lastNames.length)];
        return new Employee(fullName,
                    RANDOM.nextInt(5) + 1,
                    RANDOM.nextInt(45000) + 45000);
    }



}
