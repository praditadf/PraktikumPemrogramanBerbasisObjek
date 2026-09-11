package jobsheet03.Tugas2;

public class Kontainer {
    private String nomorResi;
    private String namaPemilik;
    private float kapasitasMaksimal;
    private float beratMuatanSaatIni;

    Kontainer(String nomorResi, String namaPemilik, float kapasitasMaksimal) {
        this.nomorResi = nomorResi;
        this.namaPemilik = namaPemilik;
        this.kapasitasMaksimal = kapasitasMaksimal;
        beratMuatanSaatIni = 0;
    }

    public String getNomorResi() {
        return nomorResi;
    }
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public float getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public void tambahMuatan(float beratTambahan) {
        if (beratTambahan > kapasitasMaksimal) {
            System.out.println("Maaf, berat muatan melebihi kapasitas maksimal kontainer.");
        } else {
            beratMuatanSaatIni += beratTambahan;
        }
    }

    public void turunkanMuatan(float beratTurunkan) {
        if (beratTurunkan > (beratMuatanSaatIni * 0.5)) {
            System.out.println("Maaf, demi keselamatan, pembongkaran muatan satu kali jalan tidak boleh melebihi 50% dari muatan saat ini!");
        }else {
            beratMuatanSaatIni -= beratTurunkan;
        }
    }

    public float getBeratMuatanSaatIni() {
        return beratMuatanSaatIni;
    }
}