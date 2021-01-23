public class Lesson2 {
    public static void main(String[] args) {
        // п.1
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        setArr1(arr1);
        // п.2
        int[] arr2 = new int[8];
        setArr2(arr2);
        // п.3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        setArr3(arr3);
        // п.4
        int[] arr4 = {9, 2, 7, 3, 4, 8, 5, 6, 1};
        getMinMax(arr4);
        // п.5*
        final int size = 8;
        int[][] arr5 = new int[size][size];
        setArr5(arr5.clone());
        setArr5Alt(arr5.clone());
        // п.6**
        int[] arrOff = {1, 2, 3, 4, 5};
        offArr(arrOff.clone(), -3);
        // п.7***
        offArrAlt(arrOff.clone(), -3);
        offArrAlt2(arrOff.clone(), -3);             // альтернативное решение
    }
    // 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    private static void setArr1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }
    // 2 Задать пустой целочисленный массив размером 8.
    // Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
    private static void setArr2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3 + 1;
        }
    }
    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ].
    // Написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    private static void setArr3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
    }
    // 4 Задать одномерный массив.
    // Написать методы поиска в нём минимального и максимального элемента;
    private static void getMinMax(int[] arr) {
        int valMin = -1;                                // минимальное значение элементов массива
        int valMax = -1;                                // максимальное значение элементов массива

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                valMin = valMax = arr[i];
            } else {
                if (arr[i] < valMin) valMin = arr[i];
                if (arr[i] > valMax) valMax = arr[i];
            }
        }
    }
    // 5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое).
    // Заполнить его диагональные элементы единицами, используя цикл(ы);
    // ВЛОЖЕННЫЙ ЦИКЛ
    private static void setArr5(int[][] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || (i + j) == (arr.length -1)) {
                    arr[i][j] = 1;
                }
            }
        }
    }
    // ОДИН ЦИКЛ
    private static void setArr5Alt(int[][] arr) {
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arr[i][i] = 1;
            arr[i][j] = 1;
        }
    }
    // 6** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным).
    // При этом метод должен циклически сместить все элементы массива на n позиций.
    //[1,2,3,4,5], -2 => [3,4,5,1,2]
    //[1,2,3,4,5], 2 => [4,5,1,2,3]
    // ВСПОМОГАТЕЛЬНЫЙ МАССИВ
    private static void offArr(int[] arr, int offset) {
        int[] arrOff = new int[arr.length];         // результирующий массив
        int iCurr;                                  // индекс для элементов входящего массива

        for (int i = 0; i < arrOff.length; i++) {
            iCurr = i - offset;
            iCurr = (arr.length + (iCurr % -arr.length)) % arr.length;

            arrOff[i] = arr[iCurr];
        }
    }
    // 7**** Не пользоваться вспомогательным массивом при решении задачи 6.
    // БЕЗ ВСПОМОГАТЕЛЬНОГО МАССИВА
    private static int[] pushArr(int[] arr, boolean reverse) {                  // метод смещения элементов массива на 1 "влево" или "вправо"
        int buf = -1;

        if (reverse) {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) buf = arr[i];
                arr[i] = i == arr.length - 1 ? buf : arr[i + 1];
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i == arr.length - 1) buf = arr[i];
                arr[i] = i == 0 ? buf : arr[i - 1];
            }
        }
        return arr;
    }
    private static void offArrAlt(int[] arr, int offset) {
        boolean reverse = offset < 0;

        if (reverse) {offset *= -1;}

        for(int i = 1; i <= offset; i++) {
            arr = pushArr(arr, reverse);
        }
    }
    // БЕЗ ВЛОЖЕННЫХ ЦИКЛОВ(смещение элементов за одно обращение к элементу массива)
    private static void offArrAlt2(int[] arr, int offset) {
        int iStart, iCurr, valNew, valCurr;
        iStart = iCurr = valNew = -1;

        for (int i = 0; i < arr.length; i++) {
            if (iCurr == iStart) {
                iCurr   = ++iStart;
                valNew  = arr[iCurr];
            }

            iCurr      += offset;
            iCurr      = (arr.length + (iCurr % -arr.length)) % arr.length;

            valCurr     = arr[iCurr];
            arr[iCurr]  = valNew;
            valNew      = valCurr;
        }
    }
}
