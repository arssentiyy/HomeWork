public class HomeWorkApp2 {

    public static void main(String[] args) {

        System.out.println("Задача1 решена: " + sumWhen10or20(7,50));
        posOrNeg(-10);
        System.out.println("Задача3 решена: " + posOrNegTrueOrFalse(-5));
        stringPrintN("Привет всем!",10);
        System.out.println("Задача 5 решена: " + leapYearTrueOrNotaLeapYearFalse(2020));
    }

    public static boolean sumWhen10or20(int a, int b){

        if (a+b>=10 && a+b<=20) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void posOrNeg (int x) {
        if (x>=0) System.out.println("Задача2 решена: Число положительное");
        if (x<0) System.out.println("Задача2 решена: Число отрицательное");
    }

    public static boolean posOrNegTrueOrFalse(int a) { // примечание, в задании 3 не написано что делать если 0
    if(a<0) {
        return true;
    }
    else {
        return false;
    }
    }

    public static void stringPrintN(String st, int a){

        for (int i = 0; i <=a; i++) {
            System.out.println("Задача 4 решена: " + st);
        }


    }

    public static boolean leapYearTrueOrNotaLeapYearFalse(int y) {
      if (y % 4 == 0 || y % 400 == 0) {
          return true;
      }
      else {
          return false;
      }
    }

}
