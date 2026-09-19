package jobsheet04.percobaan2;

public class Mobil {
    private String Merk;
    private int biaya;

    public Mobil() {

    }

    public void setMerk(String Merk) {
        this.Merk = Merk;
    }

    public String getMerk() {
        return Merk;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public int getBiaya() {
        return biaya;
    }

    public int hitungBiayaMobil(int hari) {
        return biaya * hari;
    }
}