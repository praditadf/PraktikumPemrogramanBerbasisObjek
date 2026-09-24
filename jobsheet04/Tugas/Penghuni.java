package jobsheet04.Tugas;

public class Penghuni {
    private String nama;
    private String noHp;

    public Penghuni(String nama, String noHp) {
        this.nama = nama;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public String info() {
        String info = "";
        info += "Nama: " + nama + "\n";
        info += "No HP: " + noHp + "\n";
        return info;
    }
}
