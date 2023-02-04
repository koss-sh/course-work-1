package course_work_1;

public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.addEmployee("Бадин Иван Иванович", 1, 2000000);
        methods.addEmployee("Питун Вадим Вадимович", 2, 30000);
        methods.addEmployee("Стаканенко Валентина Матвеевна", 3, 100000);
        methods.addEmployee("Шульц Олег Рудольфович", 4, 150000);
        methods.addEmployee("Жонсов Борис Борисович", 5, 1000000);
        methods.addEmployee("Бульбашенко Александр Тарасович", 2, 50000);
        methods.addEmployee("Соловьев Владимир Адольфович", 4, 100000);
        methods.addEmployee("Клинтова Лариса Вильямовна", 1, 800000);
        methods.addEmployee("Меркелова Анжела Иосифовна", 5, 210000);
        methods.addEmployee("Макаронов Иммануил Соломонович", 3, 110000);
    }
}
