// 1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
public class Employee {
    private static int id;

    private final int     vId;          // уникальный порядковый номер
    private final String  vFullName;    // ФИО

    private String  vPosition;          // должность
    private String  vPhone;             // телефон
    private int     vSalary;            // зарплата
    private int     vAge;               // возраст
    // 2 Конструктор класса должен заполнять эти поля при создании объекта;
    public Employee(String pFullName, String pPosition, String pPhone, int pSalary, int pAge) {
        this.vFullName  = pFullName;
        this.vPosition  = pPosition;
        this.vPhone     =
            pPhone == "" ? "" : String.valueOf(Long.valueOf(pPhone));
        this.vSalary    = pSalary;
        this.vAge       = pAge;
        // 7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
        this.vId        = ++id;
    }
    // 3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getFullName() {       // метод возвращает ФИО
        return vFullName;
    }
    public String getPosition() {       // метод возвращает должность
        return vPosition;
    }
    public String getPhone() {          // метод возвращает телефон
        return vPhone;
    }
    public int getSalary() {            // метод возвращает зарплату
        return vSalary;
    }
    public int getAge() {               // метод возвращает возраст
        return vAge;
    }
    public void getInfo() {             // метод возвращает всю информацию о Сотруднике
        String str;
        str =
            "ID:        " + "\t" + this.vId         + "\n" +
            "ФИО:       " + "\t" + this.vFullName   + "\n" +
            "должность: " + "\t" + this.vPosition   + "\n" +
            "телефон:   " + "\t" + this.vPhone      + "\n" +
            "зарплата:  " + "\t" + this.vSalary     + "\n" +
            "возраст:   " + "\t" + this.vAge        + "\n"
        ;
        System.out.println(str);
    }
    public void incSalary (int val) {   // метод увеличивающий зарплату Сотруднику на указанную величину
        this.vSalary += val;
    }
}
