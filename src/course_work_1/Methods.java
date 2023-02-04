package course_work_1;

public class Methods {
    public void addEmployee(String name, int department, int salary) {
        if(Employee.idCounter >= Main.employees.length) {
            System.out.println("Нельзя добавить сотрудника. Лимит: 10 человек.");
        }
        Employee.idCounter++;
        Employee newEmployee = new Employee(name, department, salary);
        Main.employees[Employee.idCounter-1] = newEmployee;
        System.out.println(Main.employees[Employee.idCounter-1]);
    }


}
