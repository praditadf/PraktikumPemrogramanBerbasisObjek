package jobsheet04.percobaan5;

public class MainPercobaan5 {
    public static void main(String[] args) {
        Mesin mesin = new Mesin();
        Mobil mobil = new Mobil("Avanza", mesin);
        mobil.tampilkanInfo();
        mobil = null;
        System.out.println(mesin.getTipe());
    }
}