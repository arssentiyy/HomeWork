public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog();

        Cat cat = new Cat();

        dog.run(100);
        dog.swimming(200);

        cat.run(300);
        cat.swimming(1000);

        System.out.println("Всего собак: " + Dog.count);
        System.out.println("Всего кошек: " + Cat.count);

    }
}
