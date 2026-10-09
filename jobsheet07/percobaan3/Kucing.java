package jobsheet07.percobaan3;

public class Kucing {
    private String nama;
    private int umur;

    public Kucing() {
        this("Tanpa Nama");
        System.out.println("Konstruktor 0 parameter selesau");
    }
    
    public Kucing(String nama) {
        this(nama, 1);
        System.out.println("Konstuktor 1 parameter selesai");
    }

    public Kucing(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        System.out.println("Konstruktor 2 parameter selesai");
    }

    public void info() {
        System.out.println("Kucing " + nama + ", umur " + umur + " tahun");
    }
}