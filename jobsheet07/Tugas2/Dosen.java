package jobsheet07.Tugas2;

public class Dosen extends Manusia {
    public void makan() {
        super.makan();
        System.out.println("Dosen makan di kantin fakultas.");
    }

    public void lembur() {
        System.out.println("Dosen lembur menilai ujian.");
    }
}
