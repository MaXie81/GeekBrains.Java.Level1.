public class Lesson1Test {
    public static void main(String[] args) {
        // Проверка выполнения заданий
        // п.1
        System.out.println("1. a = 2, b = 3, c = 7, d = 2:          " + calcFltExpr(3, 3, 2, 8));
        System.out.println("1. a = 3, b = 1, c = 4, d = 6:          " + calcFltExpr(3, 2, 4, 6));
        System.out.println("1. a = 3, b = 1, c = 3, d = 6:          " + calcFltExpr(1, 1, 3, 6));
        System.out.println();
        // п.2
        System.out.println("2. num1 = 5, num2 =  2:                 " + verifSum(5, 2));
        System.out.println("2. num1 = 7, num2 =  3:                 " + verifSum(7, 3));
        System.out.println("2. num1 = 9, num2 = 12:                 " + verifSum(9, 12));
        System.out.println();
        // п.3
        System.out.print("3. num =  7:                              ");
        chkPosNum(7);
        System.out.print("3. num =  0:                              ");
        chkPosNum(0);
        System.out.print("3. num = -3:                              ");
        chkPosNum(-3);
        System.out.println();
        // п.4
        System.out.print("4. name = Аня           :                 ");
        getHello("Аня");
        System.out.print("4. name = Максим        :                 ");
        getHello("Максим");
        System.out.print("4. name = Ольга Петровна:                 ");
        getHello("Ольга Петровна");
        System.out.println();
        // п.5*
        System.out.print("8. year =    0:                           ");
        chkLeapYear(0);
        System.out.print("8. year = 2020:                           ");
        chkLeapYear(2020);
        System.out.print("8. year = 2021:                           ");
        chkLeapYear(2021);
        System.out.print("8. year = 1900:                           ");
        chkLeapYear(1900);
        System.out.print("8. year = 2000:                           ");
        chkLeapYear(2000);
        System.out.println();
    }
    // 1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой
    // , где a, b, c, d – целочисленные входные параметры этого метода;
    private static float calcFltExpr(int a, int b, int c, int d) {
        float a_ = a;
        float b_ = b;
        float c_ = c;
        float d_ = d;

        float v = a_ * (b_ + (c_ / d_));

        return v;
    }
    // 2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно)
    // , если да – вернуть true, в противном случае – false;
    private static boolean verifSum(int num1, int num2) {
        int sum = num1 + num2;
        if(sum >= 10 && sum <= 20){
            return true;
        } else {
            return false;
        }
    }
    // 3) Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число передали, или отрицательное.
    // Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
    private static void chkPosNum(int num) {
        if(num >= 0) {
            System.out.println("число положительное");
        }
        else {
            System.out.println("число отрицательное");
        }
    }
    // 4) Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
    //  Вывести приветствие в консоль.
    private static void getHello(String name) {
        System.out.println("Привет, " + name + "!");
    }
    // 5)*Написать метод, который определяет является ли год високосным.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    // Для проверки работы вывести результаты работы метода в консоль
    private static void chkLeapYear(int year) {
        if (year == 0) {                                // если год "нулевой"
            System.out.println("год не високосный");
        } else if (year % 400 == 0) {                   // если год "каждый 400-й"
            System.out.println("год високосный");
        } else if (year % 100 == 0) {                   // если год "каждый 100-ый"
            System.out.println("год не високосный");
        } else if (year %   4 == 0) {                   // если год "каждый 4-ый"
            System.out.println("год високосный");
        } else {                                        // все остальные года
            System.out.println("год не високосный");
        }
    }
}
