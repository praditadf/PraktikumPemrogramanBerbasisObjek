package jobsheet09.tugas2;

public class MainTugas2 {
    public static void main(String[] args) {

        Destroyable[] arrayD = {
                new WalkingZombie(100, 1),
                new JumpingZombie(100, 2),
                new Barrier(100)
        };
        Plant p = new Plant();

        for (int i = 0; i < 4; i++) {
            for (Destroyable d : arrayD) {
                p.doDestroy(d);
            }
        }

        for (Destroyable d : arrayD) {
            if (d instanceof Zombie) {
                Zombie z = (Zombie)d;
                z.heal();
                System.out.println(z.getZombieInfo());
            } else if (d instanceof Barrier) {
                Barrier b = (Barrier)d;
                System.out.println(b.getBarrierInfo());
            }
        }
    }
}