public class Cat extends Animal {
    public static int count;

    public Cat (){
        count++;
    }

    @Override
    public void run(int dist) {
        if (dist > 200) {
            System.out.println("Максимальный забег кошки не более 200! А ваш параметр = " + dist);
        }
        else {
                System.out.println("Кошка пробежала: " + dist);
            }

    }

    @Override
    public void swimming(int dist) {
        System.out.println("Кошка не умеет плавать!!!");
    }
//sss

}
