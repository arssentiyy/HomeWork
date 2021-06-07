public class Dog extends Animal {
    public static int count;

    public Dog (){
        count++;
    }

    @Override
    public void run(int dist) {
        if (dist > 500) {
            System.out.println("Максимальный забег собаки не более 500! А ваше параметр = " + dist);
        }
        else {
            System.out.println("Собака пробежала: " + dist);
        }

    }

    @Override
    public void swimming(int dist) {
        if (dist > 10) {
            System.out.println("Максимальный заплыв собаки не более 10! А ваше параметр = " + dist);
        }
        else {
            System.out.println("Собака проплыла: " + dist);
        }
    }
}
