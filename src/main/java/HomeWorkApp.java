public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void checkSumSign() {

        int a;
        int b;
        a=-10;
        b=6;

        if (a+b>0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    static void printColor() {
        int value;
        value=0;
        if (value<=0) {
            System.out.println("Красный");
        }
        else if(value>0 && value<=100 ) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }
    static void compareNumbers() {
        int a;
        int b;
        a=-80;
        b=20;

        if (a>=b) {
            System.out.println("a>=b");
        }
        else {
            System.out.println("a<b");
        }
    }

}
