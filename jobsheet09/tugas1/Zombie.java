package jobsheet09.tugas1;

public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public Zombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    public abstract void heal();

    public abstract void destroyed();

    public String getZombieInfo() {
        return "Health = " + health + " Level = " + level;
    }
}
