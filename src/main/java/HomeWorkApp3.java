import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {
    public static void main(String[] args) {

        //int[] argb = {1, 2, 2, 3, 4, 4};
        int[] argb = {3, 5, 6, 1};

        replaceZeroOne();
        mass100();
        replace62();
        massDiagonal();
        lenInitialValue(10, 7);
        findMaxAndMin();
        System.out.println(sumArrLeftRightBalance(argb));
        arrChange(argb, -2);
    }


    static void replaceZeroOne() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] == 0) {
                arr [i] = 1;
            } else {
                arr [i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    } // 1 задание

    static void mass100() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    } // 2 задание

    static void replace62() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < 6) arr [i] = arr [i] * 2;
        }
        System.out.println(Arrays.toString(arr));
    } // 3 задание

    static void massDiagonal() {
        Random rand = new Random();
        int[][] table = new int[8][8];
        int t = table.length ;

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                int x = rand.nextInt(10);
                table[i][j] = x;
                if (i == j || i + j == t - 1) table[i][j] = 1;
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    } // 4 задание

    static void lenInitialValue (int len, int  initialValue) {

        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
    } // 5 задание

    static void findMaxAndMin() {
        int[] arr = { 5, 7, 6, 10, 50, 4, 3, 8, -9, 30 };
        int max = arr[1];
        int min = arr[1];

        for (int i = 0; i < 10; i++) {
           if (arr[i] >= max) {
               max = arr[i];
           } else if (arr[i] <= min) {
               min = arr[i];
           }
        }
        System.out.println("Максимальное = " + max + " Минимальное = " + min);

    } // 6 задание

    static boolean sumArrLeftRightBalance(int[] argb) {
        float sum = 0;
        float b = 0;
        for (int i = 0; i < argb.length; i++) {
            sum += argb[i]; // сначала посчитаем сумму
        }
        for (int i = 0; i < argb.length; i++) {
            b += argb[i]; // суммируем элементы
            if (b != 0) {
                if (sum / b == 2) { // проверяем если сумма делится на b и получается круглая 2 йка без дробной части тогда баланс есть)))
                    return true;
                }
            }
        }
        return false;
    }

    static void arrChange(int[] argb, int n) {
        int len = argb.length;
        int x = 0;
        int y = 0;

        for (int i = 0; i < len; i++) {
           if (i + n < 0) {
               x = i + Math.abs(n);
               y = argb [i];
               argb[i] = argb[x];
               argb[x] = y;
           } else if (i + n > 0 && i + n != len - 1 && i + Math.abs(n) <= len -1) {
               x = i + Math.abs(n);
               y = argb[i];
               argb[i] = argb[x];
               argb[x] = y;
           } else if (i + n == len - 1) {
               y = argb[0];
               argb[0] = argb[len - 1];
               argb[len - 1] = y;
           } else if (n == 0) {
               break;
           }

        }
        System.out.println(Arrays.toString(argb));
    }

}

