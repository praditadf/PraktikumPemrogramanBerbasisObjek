package jobsheet04.percobaan4;

public class Gerbong {
    private String kode;
    private Kursi[] arrayKursi;

    public Gerbong(String kode, int jumlah) {
        this.kode = kode;
        this.arrayKursi = new Kursi[jumlah];
        this.initKursi();
    }

    private void initKursi() {
        for (int i = 0; i < arrayKursi.length; i++) {
            this.arrayKursi[i] = new Kursi(String.valueOf(i + 1));
        }
    }

    public void setPenumpang(Penumpang penumpang, int nomor) {
        if (nomor < 1 || nomor > arrayKursi.length) {
            System.out.println("Kursi tidak tersedia.");
        }else if (arrayKursi[nomor - 1].getPenumpang() != null) {
            System.out.println("Kursi sudah ada penumpang lain.\n");
        } else {
            arrayKursi[nomor - 1].setPenumpang(penumpang);
        }
    }

    public String info() {
        String info = "";
        info += "Kode: " + kode + "\n";
        for (Kursi kursi : arrayKursi) {
            info += kursi.info();
        }
        return info;
    }
}