package alternate_cw;

import java.util.Random;

public class Main {
    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {
        fillEmployees();
        printFullInfo();
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
}
