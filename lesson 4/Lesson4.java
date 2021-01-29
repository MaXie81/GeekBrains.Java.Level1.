public class Lesson4 {
    public static void main(String[] args) {
        Employee employee;

        employee = new Employee(
                "Зыков Артем Петрович",
                "сотрудник",
                "4951000001",
                25000,
                26
        );
        // 4 Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("ФИО: " + employee.getFullName() + ", должность: " + employee.getPosition() + "\n");

        Employee[] arrEmployee = new Employee[7];
        // 5 Создать массив из 5 сотрудников.
        setArrEmployee(arrEmployee);
        // 5 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        for (Employee empl : arrEmployee) {
            if (empl.getAge() > 40)
                empl.getInfo();
        }
        // 6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
        for (Employee empl : arrEmployee) {
            if (empl.getAge() > 35)
                empl.incSalary(10000);
        }
    }
    private static void setArrEmployee(Employee[] arr) {
        arr[0] = new Employee(
                "Иванов Иван Иванович",
                "генеральный директор",
                "4957770001",
                500000,
                56
        );
        arr[1] = new Employee(
                "Сидорова Анна Петровна",
                "главный бухгалтер",
                "4957770002",
                100000,
                52
        );
        arr[2] = new Employee(
                "Гривенко Игорь Александрович",
                "старший менеджер",
                "4957770003",
                80000,
                37
        );
        arr[3] = new Employee(
                "Рудаков Семен Павлович",
                "младший менеджер",
                "4957770004",
                40000,
                28
        );
        arr[4] = new Employee(
                "Каримов Максим Эдуардович",
                "младший менеджер",
                "4957770005",
                37000,
                25
        );
        arr[5] = new Employee(
                "Нестерова Наталья Николаевна",
                "секретарь",
                "4957770006",
                32000,
                24
        );
        arr[6] = new Employee(
                "Самокрутова Антонина Макаровна",
                "уборщица",
                "",
                17000,
                67
        );
    }
}
