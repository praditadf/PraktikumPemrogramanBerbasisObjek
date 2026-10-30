package jobsheet10.tugas;

public class Keledai extends Binatang implements IHerbivora {
    private String suara;
    private String warnaBulu;

    public Keledai(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void displayBinatang() {
        System.out.println("Jenis: Herbivora");
    }

    public void displayMakan() {
        System.out.println("Makanan: Tumbuhan");
    }

    public void displayData() {
        displayBinatang();
        displayMakan();
        System.out.println("Nama: " + getNama());
        System.out.println("Jumlah Kaki: " + getKaki());
        System.out.println("Suara: " + this.suara);
        System.out.println("Warna Bulu: " + this.warnaBulu + "\n");
    }
}