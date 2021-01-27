import java.util.Random;
import java.util.Scanner;

public class Lesson3Master {
    public static final char SYM_EAMPTY     = '_';
    public static final char SYM_HUMAN      = 'O';
    public static final char SYM_COMPUTER   = 'X';

    public static final Scanner inScan = new Scanner(System.in);
    public static final Random  getRnd = new Random();

    public static char[][] arrMap;                      // поле-массив для игры
    public static final int mapSize = 3;                // размер поля игры
    public static int x, y;                             // координаты последнего сделанного хода

    public static final int cntWin = 3;                 // кол-во подряд идущих меток для победы в игре
    public static int cntStep;                          // кол-во оставшихся ходов до завершения игры

    public static boolean flgHumStep = false;           // признак хода Игрока

    public static int xCalc;
    public static int yCalc;

    public static void main(String[] args) {
        System.out.println("Укажите размер поля для игры: " + mapSize);

        System.out.println("Укажите кол-во подряд идущих меток для победы в игре: " + cntWin);

        cntStep = mapSize * mapSize;                    // устанавливаем максимально возможное кол-во ходов за игру
        flgHumStep = getRnd.nextBoolean();              // определяем кто ходит первым

        initMap();
        showMap();

        while (!chkGame()) doStep();

        System.out.println();
        if (chkCnt())
            System.out.println("Победил " + (flgHumStep ? "Игрок" : "Компьютер") + "!");
        else
            System.out.println("Победитель не определен. Ничья.");

        inScan.close();
    }
    // Утилиты
    private static void initMap() {                     // заполнение поля игры пустыми ячейками
        arrMap = new char[mapSize][mapSize];
        for (int y = 0; y < arrMap.length; y++)
            for (int x = 0; x < arrMap[y].length; x++)
                arrMap[y][x] = SYM_EAMPTY;
    }
    private static void showMap() {                     // вывод поля игры с заполненными ячейками
        for (int x = 0; x < arrMap.length; x++ ) {
            System.out.print((x == 0 ? "   " : " ") + (x + 1));
        }
        System.out.println();

        for (int y = 0; y < arrMap.length; y++) {
            for (int x = 0; x < arrMap[y].length; x++)
                System.out.print((x == 0 ? (y + 1) + " |": "") + arrMap[y][x] + "|");
            System.out.println();
        }
    }
    // Анализ заполнения поля игры
    private static boolean chkCnt() {                   // определение достаточного кол-ва подряд заполненных ячеек
        int x1, y1, x2, y2;
        int cnt1, cnt2;
        // по горизонтали и вертикали
        for (int i = 0; i < mapSize; i++) {
            x1 = 0;
            y1 = i;
            x2 = i;
            y2 = 0;

            cnt1 = cnt2 = 0;

            for (int j = 0; j < mapSize && x1 < mapSize && y2 < mapSize; j++, x1++, y2++) {
                cnt1 = incCnt(y1, x1, cnt1);        // по горизонтали
                cnt2 = incCnt(y2, x2, cnt2);        // по вертикали

                if (cnt1 == cntWin || cnt2 == cntWin) return true;
            }
        }
        // по прямой диагонали
        for (int i = 0; i < mapSize; i++) {
            x1 = 0;
            y1 = i;
            x2 = i;
            y2 = 0;

            cnt1 = cnt2 = 0;

            for (int j = 0; j < mapSize && x1 < mapSize && y1 < mapSize && x2 < mapSize && y2 < mapSize; j++, x1++, y1++, x2++, y2++) {
                cnt1 = incCnt(y1, x1, cnt1);        // слева
                cnt2 = incCnt(y2, x2, cnt2);        // справа

                if (cnt1 == cntWin || cnt2 == cntWin) return true;
            }
        }
        // по обратной диагонали
        for (int i = mapSize - 1; i >=  0; i--) {
            x1 = 0;
            y1 = i;
            x2 = mapSize - 1 - i;
            y2 = mapSize - 1;

            cnt1 = cnt2 = 0;

            for (int j = 0; j < mapSize && x1 < mapSize && y1 >= 0 && x2 < mapSize && y2 >= 0; j++, x1++, y1--, x2++, y2--) {
                cnt1 = incCnt(y1, x1, cnt1);        // слева
                cnt2 = incCnt(y2, x2, cnt2);        // справа

                if (cnt1 == cntWin || cnt2 == cntWin) return true;
            }
        }
        return false;
    }
    private static int incCnt(int y, int x, int cnt) {  // инкримент счетчика подряд идущих меток
        if (arrMap[y][x] == (flgHumStep ? SYM_HUMAN : SYM_COMPUTER)) {
            return ++cnt;
        } else {
            return 0;
        }
    }
    // Проверки
    private static boolean chkStep() {              // проверка хода
        return (x >= 0 && x < mapSize && y >= 0 && y < mapSize) && arrMap[y][x] == SYM_EAMPTY;
    }
    private static boolean chkGame() {              // проверка игры
        if (chkCnt() || cntStep == 0) {             // есть победитель или не осталось ходов
            return true;                            // игра окончена
        }
        else {
            flgHumStep = !flgHumStep;               // переход хода
            return false;                           // продолжаем игру
        }
    }
    // Действия
    private static void doStep() {                   // выполнение хода
        System.out.println();

        if (flgHumStep)
            doHum();
        else
            doComp();

        setStep();                                  // фиксируем ход
        showMap();                                  // выводим поле со сделанными ходами
    }
    private static void doHum() {                   // ход Игрока
        do {
            System.out.print("Введите координаты шага: ");
            x = inScan.nextInt() - 1;
            y = inScan.nextInt() - 1;
        } while (!chkStep());
    }
    private static void doComp() {                  // ход Компьютера
//        do {
//            x = getRnd.nextInt(mapSize);
//            y = getRnd.nextInt(mapSize);
//        } while (!chkStep());

        calcStep();
        x = xCalc;
        y = yCalc;

        System.out.println("Координаты шага компьюетра: " + (x + 1) + " " + (y + 1));
    }
    private static void setStep() {                 // фиксация хода
        arrMap[y][x] = flgHumStep ? SYM_HUMAN : SYM_COMPUTER;       // запись в ячейку поля игры метки очередного хода
        cntStep--;                                                  // уменьшение счетчика кол-ва оставшихся ходов
    }
    // РАСЧЕТ ХОДА
    private static void cloneArrMap(char[][] arr) { // создание копии поля игры
        for (int y = 0; y < mapSize; y++)
            for (int x = 0; x < mapSize; x++)
                arr[y][x] = arrMap[y][x];
    }
    private static void calcStep() {                // расчет хода
        char[][] arrCur = new char[mapSize][mapSize];

        int sumMax = -10;
        int sumCur;

        xCalc = -1;
        yCalc = -1;

        for (int y = 0; y < mapSize; y++)
            for (int x = 0; x < mapSize; x++) {
                if (arrMap[y][x] != SYM_EAMPTY) continue;
                cloneArrMap(arrCur);

                arrCur[y][x] = flgHumStep ? SYM_HUMAN : SYM_COMPUTER;

                sumCur = calcSum(arrCur);

                if (sumCur > sumMax) {
                    sumMax = sumCur;
                    xCalc = x;
                    yCalc = y;
                }
            }
    }
    private static int calcSum(char[][] arr) {      // расчет суммы хода
        final char symMine = flgHumStep ? SYM_HUMAN : SYM_COMPUTER;
        final char symAlien = flgHumStep ? SYM_COMPUTER : SYM_HUMAN;

        int[] xSum, ySum;
        int[] dSum;

        char sym;
        int sum = 0;

        xSum = new int[mapSize];
        ySum = new int[mapSize];
        dSum = new int[2];

        for (int y = 0; y < mapSize; y++) {
            xSum[y] = 0;
            sym = '?';
            for (int x = 0; x < mapSize; x++) {
                if (arr[y][x] == SYM_EAMPTY) continue;

                if ( sym == '?' ) {
                    sym = arr[y][x];
                    xSum[y] += (sym == symMine ? 1 : -1);
                } else {
                    if ( sym == arr[y][x] )
                        xSum[y] += (sym == symMine ? 1 : -1);
                    else {
                        xSum[y] = 0;
                        break;
                    }
                }
            }
        }
        for (int x = 0; x < mapSize; x++) {
            ySum[x] = 0;
            sym = '?';
            for (int y = 0; y < mapSize; y++) {
                if ( arr[y][x] == SYM_EAMPTY ) continue;

                if ( sym == '?' ) {
                    sym = arr[y][x];
                    ySum[x] += (sym == symMine ? 1 : -1);
                } else {
                    if ( sym == arr[y][x] )
                        ySum[x] += (sym == symMine ? 1 : -1);
                    else {
                        ySum[x] = 0;
                        break;
                    }
                }
            }
        }

        dSum[0] = 0;
        sym = '?';
        for (int j = 0; j < mapSize; j++) {
            if ( arr[j][j] == SYM_EAMPTY ) continue;

            if ( sym == '?' ) {
                sym = arr[j][j];
                dSum[0] += (sym == symMine ? 1 : -1);
            } else {
                if ( sym == arr[j][j] )
                    dSum[0] += (sym == symMine ? 1 : -1);
                else {
                    dSum[0] = 0;
                    break;
                }
            }
        }
        dSum[1] = 0;
        sym = '?';
        for (int j = 0; j < mapSize; j++) {
            if ( arr[mapSize - 1 - j][j] == SYM_EAMPTY ) continue;

            if ( sym == '?' ) {
                sym = arr[mapSize - 1 - j][j];
                dSum[1] += (sym == symMine ? 1 : -1);
            } else {
                if ( sym == arr[mapSize - 1 - j][j] )
                    dSum[1] += (sym == symMine ? 1 : -1);
                else {
                    dSum[1] = 0;
                    break;
                }
            }
        }
        for(int i = 0; i < mapSize; i++) {
            sum += (xSum[i] + ySum[i]);
            sum += xSum[i] == -2 || ySum[i] == -2 ? -1 : 0;
        }
        sum += dSum[0] + dSum[1];
        sum += dSum[0] == -2 || dSum[1] == -2 ? -1 : 0;
        return sum;
    }
}
