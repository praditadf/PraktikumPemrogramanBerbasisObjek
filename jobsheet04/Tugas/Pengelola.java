package jobsheet04.Tugas;

public class Pengelola {
    private String nama;

    public Pengelola(String nama) {
        this.nama = nama;
    }

    public void tagihSewa(Penghuni penghuni, int biaya) {
        System.out.println("Pengelola " + nama + " menagih kepada " + penghuni.getNama() + " sebesar Rp" + biaya + ".\n");
    }
}
