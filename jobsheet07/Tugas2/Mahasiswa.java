package jobsheet07.Tugas2;

public class Mahasiswa extends Manusia {
    public void makan() {
        super.makan();
        System.out.println("Mahasiswa makan di kantin kampus.");
    }

    public void tidur() {
        System.out.println("Mahasiswa tidur di perpustakaan.");
    }
}
