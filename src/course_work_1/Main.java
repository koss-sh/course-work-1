package course_work_1;

public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Methods.addEmployee("Бадин Иван Иванович", 1, 2000000);
        Methods.addEmployee("Питун Вадим Вадимович", 2, 30000);
        Methods.addEmployee("Стаканенко Валентина Матвеевна", 3, 100000);
        Methods.addEmployee("Шульц Олег Рудольфович", 4, 150000);
        Methods.addEmployee("Жонсов Борис Борисович", 5, 1000000);
        Methods.addEmployee("Бульбашенко Александр Тарасович", 2, 50000);
        Methods.addEmployee("Соловьев Владимир Адольфович", 4, 100000);
        Methods.addEmployee("Клинтова Лариса Вильямовна", 1, 800000);
        Methods.addEmployee("Меркелова Анжела Иосифовна", 5, 210000);
        Methods.addEmployee("Макаронов Иммануил Францевич", 3, 110000);
        Methods.getAllEmployees();
        Methods.countTotalSalary();
        Methods.findMinSalary();
        Methods.findMaxSalary();
        Methods.countAverageSalary();
        Methods.printAllEmployees();
        employees[1].setSalary(55555);
        employees[2].setDepartment(1);
        Methods.getAllEmployees();
        Methods.countTotalSalary();
        Methods.findMinSalary();
        Methods.findMaxSalary();
        Methods.countAverageSalary();
    }
}
