package jobsheet07.percobaan5;

public class Staff extends Karyawan {
    private int jamLembur;
    private double tarifLembur;

    public Staff(String nip,String nama, String golongan, int jamLembur, double tarifLembur) {
        super(nip, nip, golongan);
        this.jamLembur = jamLembur;
        this.tarifLembur = tarifLembur;
    }

    public double getGaji(int jamLembur, double tarifLembur) {
        return super.getGaji() + jamLembur * tarifLembur;
    }

    @Override
    public double getGaji() {
        return getGaji(jamLembur, tarifLembur);
    }

    @Override
    public void lihatInfo() {
        super.lihatInfo();
        System.out.println("Jam lembur   : " + jamLembur);
        System.out.printf("Tarif/jam    : %.0f%n", tarifLembur);

    }
}