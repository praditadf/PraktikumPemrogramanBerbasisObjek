package jobsheet10.tugas;

public class Singa extends Binatang implements IKarnivora {
    private String suara;
    private String warnaBulu;

    public Singa(String nama, int jmlKaki, String suara, String warnaBulu) {
        super(nama, jmlKaki);
        this.suara = suara;
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void displayBinatang() {
        System.out.println("Jenis: Karnivora");
    }

    public void displayMakan() {
        System.out.println("Makanan: Daging");
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