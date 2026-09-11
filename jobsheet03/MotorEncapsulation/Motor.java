package jobsheet03.MotorEncapsulation;

public class Motor {
    private int kecepatan = 0;
    private boolean kontanOn = false;

    public void nyalakanMesin() {
        kontanOn = true;
    }

    public void matikanMesin() {
        kontanOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan() {
        if (kontanOn == true) {
            kecepatan += 5;
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena Mesin Off! \n");
        }
    }

    public void kurangiKecepatan() {
        if (kontanOn == true) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena Mesin Off! \n");
        }
    }

    public void printStatus() {
        if (kontanOn == true) {
            System.out.println("Kontak On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan " + kecepatan + "\n");
    }

}