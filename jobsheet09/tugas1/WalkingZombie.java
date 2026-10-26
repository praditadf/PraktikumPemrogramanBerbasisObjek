package jobsheet09.tugas1;

public class WalkingZombie extends Zombie {
    public WalkingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                health = Math.min(health + health * 10 / 100, 100);
                break;
            case 2:
                health = Math.min(health + health * 30 / 100, 100);
                break;
            case 3:
                health = Math.min(health + health * 40 / 100, 100);
                break;
            default:
                break;
        }
    }

    @Override
    public void destroyed() {
        health -= health * 20 / 100;
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data = " + super.getZombieInfo() + "\n";
    }
}