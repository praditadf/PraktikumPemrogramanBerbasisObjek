package jobsheet04.Tugas;

public class Kos {
    private String nama;
    private Kamar [] arrayKamar;

    public Kos(String nama, int jumlah) {
        this.nama = nama;
        this.arrayKamar = new Kamar[jumlah];
        this.initKamar();
    }

    private void initKamar() {
        for (int i = 0; i < arrayKamar.length; i++) {
            arrayKamar[i] = new Kamar(String.valueOf(i + 1));
        }
    }

    public void setPenghuni(Penghuni penghuni, int nomor) {
        if (nomor < 1 || nomor > arrayKamar.length) {
            System.out.println("Kamar tidak tersedia.");
        } else if (arrayKamar[nomor - 1].getPenghuni() != null) {
            System.out.println("Kamar sudah ada penghuni lain.\n");
        } else {
            arrayKamar[nomor - 1].setPenghuni(penghuni);
        }
    }

    public String info() {
        String info = "";
        info += "Kos: " + nama + "\n";
        for (Kamar kamar : arrayKamar) {
            info += kamar.info();
        }
        return info;
    }
}
