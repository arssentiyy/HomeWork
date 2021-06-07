public abstract class Animal {

    private final String name;
    private final int satiety;

    public Animal(String name, int satiety) { // satiety - сытость
        this.name = name;
        this.satiety = satiety;
    }

    abstract void run(int dist);
    abstract void swimming(int dist);

}
