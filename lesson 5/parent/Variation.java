package parent;

import java.util.Random;
// Класс внесения разброса в передаваемое значение в пределах заданного процента
class Variation {                                                       // только для функционала пакета parent
    private static int pctMax;                                          // максимально возможный процент отклонения

    private static float pct;
    private static boolean flgNeg;
    private static int result;

    private static Random objRandom = new Random();

    static void setPctMax(int pct) {
        pctMax = pct;
    }
    static int getVal(int val) {                                        // для целочисленных значений
        flgNeg  = objRandom.nextBoolean();                              // знак
        pct     = objRandom.nextInt(pctMax) / 100f;                     // процент

        result = (int)(val +(val * pct * (flgNeg ? -1 : 1)));

        return result;
    }
    static float getVal(float val) {                                    // для дробных значений
        flgNeg  = objRandom.nextBoolean();
        pct     = objRandom.nextInt(pctMax) / 100f;

        result = (int)((val +(val * pct * (flgNeg ? -1 : 1))) * 100);   // округление до 2-х знаков после запятой

        return result / 100f;
    }
}
